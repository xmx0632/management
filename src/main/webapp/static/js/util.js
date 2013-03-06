	function getExt(path){
		var ext=path.substring(path.lastIndexOf("."),path.length).toUpperCase();
		return ext;
	}
	
	function isInvalidImgExt(ext){
		return ext!=""&&ext!=".PNG"&&ext!=".JPG";
	}
	
	function previewNormal(){
		 var filePath = "";
		 
	 	if(navigator.userAgent.indexOf("MSIE")>0) {
			filePath = document.getElementById('iosNormalIcon').value;
			filePath = "file:///" + filePath;
			filePath = filePath.replace(/\\/g,"/");
			
		} else { 
			filePath = window.URL.createObjectURL(document.getElementById("iosNormalIcon").files[0]);
		}
	 	
	 	
	 	document.getElementById("iosNormalImg").src=filePath;
	}
	
	function previewRetina(){
		 var filePath = "";
		 
	 	if(navigator.userAgent.indexOf("MSIE")>0) {
			filePath = document.getElementById('iosRetinaIcon').value;
			filePath = "file:///" + filePath;
			filePath = filePath.replace(/\\/g,"/");
			
		} else { 
			filePath = window.URL.createObjectURL(document.getElementById("iosRetinaIcon").files[0]);
		}
	 	document.getElementById("iosRetinaImg").src=filePath;
	}
	
	function previewImg(fileinput,img){
		 var filePath = "";
		 
	 	if(navigator.userAgent.indexOf("MSIE")>0) {
			filePath = document.getElementById(fileinput).value;
			filePath = "file:///" + filePath;
			filePath = filePath.replace(/\\/g,"/");
			
		} else { 
			filePath = window.URL.createObjectURL(document.getElementById(fileinput).files[0]);
		}
	 	document.getElementById(img).src=filePath;
	}