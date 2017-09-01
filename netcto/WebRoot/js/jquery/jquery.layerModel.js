/**
 * jQuery��������
 * 
 * @author zhoukun@sinovatech.com
 * @since 2013-08-23
 */
(function($) {
	/**
	 * center : ʼ�մ�����������м� locked : �Ƿ���ֱ������ֲ�,����DOM fixed �� �Ƿ�̶�λ�� 
	 * drag : �Ƿ�֧���϶� zIndex : ���ֵ opacity : ���ֲ�͸���� close : �ر�ʱ�Ļص�����������true�Ż�ر�
	 */
	var methods = {
		o : {
			isIe : !-[ 1, ] || document.documentMode >= 9,//��������ж�IE9��IE10��
			ie6 : !-[ 1, ] && !window.XMLHttpRequest,
			ie9_10 : document.documentMode >= 9,
			bgLayer : "layerModel_mask",
			dataId : "layerModel_main",
			wrapper : "layerModel_wrapper",
			warpperContent : "layerModel_content",
			warpperTitle : "layerModel_title",
			warpperCloseBtn : "layerModel_closeBtn",
			warpperOwnContent : "layerModel_ownContent",
			replaceClose : "replaceClose",
			defaultWidth : 300
		},
		generateId : function(){
			return "_" + new Date().getTime();
		},
		init : function(data, options) {
			//left��top��Ҫʹ�õ�ʱ��������centerΪfalse������������²Ż���Ч�����center = true������ò���Ч
			//#666,#999,#e5dfda ,#e5e5e5,#ff8800
			var defaults = {center:true,locked:true,fixed:true,drag:true,zIndex:9999,opacity:"0.5",title:"ϵͳ��ʾ",width:0,height:0,timer:0,bgColor:"#999",left:350,top:100,head:true,isClose:true,
					close : function(){
						return true;
					}
				};
			options = $.extend(defaults, options);
			var s = this;
			var generateId = s.generateId();
			if (typeof data === 'object') {
				data = data instanceof $ ? data : $(data);
				data = s.createContainer(data, options, generateId).hide();
			} else if (typeof data === 'string' || typeof data === 'number') {
				data = $("<div id='"+s.o.dataId + generateId +"'></div>").html(data).appendTo(document.body).hide();
			} else {
				alert("Layer Error : Unsupporte data type :" + typeof data);
				return;
			}
			if (options.locked && !s.hasBgLayer()) {
				$("<div class='"+s.o.bgLayer+"' id='" + s.o.bgLayer + "'></div>").appendTo(document.body).css({"background" : options.bgColor,"opacity" : options.opacity});
			}
			data.css({"position" : options.fixed ? s.o.ie6 ? "absolute" : "fixed" : "absolute","z-index" : options.zIndex,"left" : options.left,"top" : options.top}).show();
			if (options.center) {
				s.fixLayer(data);
				$(window).bind("resize scroll", function() {
					s.fixLayer(data);
				});
			}
			if (options.drag) {
				s.dragLayer(data, options);
			}
			var timeOut;
			clearTimeout(timeOut);
			if(options.timer > 0){
				timeOut = window.setTimeout(function(){
					$("#"+s.o.replaceClose + generateId).trigger("click");
				}, options.timer);
			}
			return data;
		},
		createContainer : function(data, options,generateId) {
			var s = this;
			//���contextδ���壬����ͨ��htmlƴ�ӵķ�ʽ׷�ӵķ������ԭ���ʹ��ڵģ��رպ���Ҫ����ԭ�ط�
			var isHtmlSlice = data.context == undefined ? true : false;
			var wrapperHtml = "<div class='"+s.o.wrapper+"' id='"+s.o.wrapper + generateId+"'>"
								+ "<div class='"+s.o.warpperContent+"' id='"+s.o.warpperContent + generateId+"'>"
								+ "<a class='"+s.o.replaceClose+"' id='"+s.o.replaceClose + generateId+"'></a>";
								if(options.head){
									wrapperHtml+= "<h4 class='"+s.o.warpperTitle+"' id='"+s.o.warpperTitle + generateId+"'>";
									if(options.isClose){
										wrapperHtml+= "<a href='javascript:void(0);' title='�ر�' class='"+s.o.warpperCloseBtn+"' id='"+s.o.warpperCloseBtn + generateId+"'>" +"&times;"+ "</a>"; 
									}
									wrapperHtml+= options.title + "</h4>";
								}
								wrapperHtml+= "<div id='"+s.o.warpperOwnContent + generateId+"' class='"+s.o.warpperOwnContent+"'></div>"
								+ "</div>"
							+ "</div>";
			s.container = $(wrapperHtml);
			s.container.appendTo(document.body);
			data.clone(true).appendTo("#"+s.o.warpperOwnContent + generateId).show().attr('id',data.attr('id') || s.o.dataId + generateId);
			//divĬ�Ͽ��Ϊ100%�����Խ��齫���е�����Ԫ�����ÿ�ȣ����򵯳�����Ϊ100%
			var w = $("#"+data.attr('id')).width() || $("#"+s.o.dataId + generateId).width() || s.o.defaultWidth;
			//ָ���˸߶�
			var tempWidth = w;
			if(options.height > 0 ) {
				if(options.width > 0){
					tempWidth = options.width;
					if(options.width <= w){
						$("#"+s.o.warpperOwnContent + generateId).css({"width":options.width,"overflow-x":"auto"});
					} else {
						//���ָ���Ŀ�ȴ���Ԫ�ر���Ŀ�ȣ���ô��Ҫ��Ԫ�ؾ���
						//��Ԫ��ʼ�վ�����ʾ
						var xPadding = (options.width - w) / 2 + 8;
						$("#"+s.o.warpperOwnContent + generateId).css({"padding" : "4px " + xPadding + "px"});
					}
				}
				s.container.width(tempWidth + 32);
				$("#"+s.o.warpperContent + generateId).width(tempWidth + 30);
				$("#"+s.o.warpperOwnContent + generateId).css({"height":options.height,"overflow-y":"auto"});
			} else {
				if(options.width > 0) {
					tempWidth = options.width;
					if(options.width <= w) {
						$("#"+s.o.warpperOwnContent + generateId).css({"width":options.width,"overflow-x":"auto"});
					}
				}
				s.container.width(tempWidth + 22);
				$("#"+s.o.warpperContent + generateId).width(tempWidth + 20);
			}
			$("#"+s.o.warpperCloseBtn + generateId).click(function(e) {
				$("#"+s.o.replaceClose + generateId).trigger("click");
			});
			$("#"+s.o.replaceClose + generateId).click(function(e) {
				s.close($("#"+s.o.wrapper + generateId), options, generateId);
				e.stopPropagation();
			});
			if(!isHtmlSlice){
				// �ô����Ԫ���ڶԻ���رպ���Է��ص�ԭ���ĵط�
	            var display = data.css("display");
	            var obj = data[0];
	            var prev = obj.previousSibling;
	            var next = obj.nextSibling;
	            var parent = obj.parentNode;
	            this["elemBack_" + generateId] = function(){
	                if (prev && prev.parentNode) {
	                    prev.parentNode.insertBefore(obj, prev.nextSibling);
	                } else if (next && next.parentNode) {
	                    next.parentNode.insertBefore(obj, next);
	                } else if (parent) {
	                    parent.appendChild(obj);
	                };
	                data.css({"display" : display});
	            };
			}
			data.detach();
			return s.container;
		},
		isLastLayer : function(){
			var s = this;
			return $("." + s.o.wrapper).length <= 0;
		},
		hasBgLayer : function(){
			var s = this;
			return $("." + s.o.bgLayer).length > 0;
		},
		close : function(data, options ,generateId) {
			var s = this;
			//���ûص�����
			var result = options.close();
			if(result){
				data.remove();
				if(s.isLastLayer()) {
					$("#" + s.o.bgLayer).remove();
				}
			}
			if (this["elemBack_" + generateId]) {
		        this["elemBack_" + generateId]();
		    };
		},
		closeLayer : function(obj){
			var s = this;
			$(obj).parent().parent().parent().hide();
			//if(s.isLastLayer()) {
				$("#" + s.o.bgLayer).hide();
			//}
		},
		fixLayer : function(data) {
			var s = this;
			var T = ($(window).height() - data.innerHeight()) / 2 + (s.o.ie6 ? $(document).scrollTop() : data.scrollTop());
			var L = ($(window).width() - data.width()) / 2 + (s.o.ie6 ? $(document).scrollLeft() : data.scrollLeft());
			data.css({"left" : L,"top" : T});
		},
		dragLayer : function(data, options) {
			var s = this;
			var move = false;// �ƶ����
			var x = 0, y = 0;// �����ؼ����Ͻǵ����λ��
			var o = data.find("." + s.o.warpperTitle).css({"cursor" : "move"});
			var a = o[0];
			o.mousedown(function(e) {
				//IE9 IE10��Ȼ��e.button�ĳ�0�ˣ�ܳ
				var isLeftClick = (s.o.isIe && e.button == 1) || (!s.o.isIe && e.button == 0) || (s.o.ie9_10 && e.button == 0);
				if (isLeftClick) {
					data.fadeTo(20, 0.25);// �����ʼ�϶���͸����ʾ
					s.o.isIe ? a.setCapture() : window.captureEvents(Event.MOUSEMOVE);
					move = true;
					x = e.pageX - parseInt(data.css("left"));
					y = e.pageY - parseInt(data.css("top"));
					$(document).mousemove(function(e) {
						if (move) {
							var sx = e.pageX - x;// �ƶ�ʱ�������λ�ü���ؼ����Ͻǵľ���λ��
							var sy = e.pageY - y;
							data.css({"top" : sy,"left" : sx});
						}
					}).mouseup(function() {
						data.fadeTo("fast", 1);// �ɿ�����ֹͣ�ƶ����ָ��ɲ�͸��
						move = false;
						x = 0;
						y = 0;
						s.o.isIe ? a.releaseCapture() : window.captureEvents(Event.MOUSEMOVE|Event.MOUSEUP);
					});
				} else {
                    return false;
                }
			});
		}
	};
	$.fn.layerModel = function(options) {
		methods.init(this, options);
	};
	$.fn.close =  function() {
		methods.closeLayer(this);
	};
})(jQuery);