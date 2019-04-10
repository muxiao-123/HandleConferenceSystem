$(function(){
			function opc(){
				$("body").animate({"opacity":1},1000);
				
			}
			var ooo=setTimeout(opc,500);
			function yl(){
				var hf=[];
				$("body").find("a").each(function(i){
					hf[i]=$(this).attr("href");
					$(this).attr("href","javascript:;");
					$(this).bind("click",function(event){
						$("body").animate({"opacity":0},500);
						window.setTimeout(function(){
							location.href=hf[i];},500);
					})
				})
			}
			yl();
		})