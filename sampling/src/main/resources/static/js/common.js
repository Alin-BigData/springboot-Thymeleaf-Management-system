//导航选择器
var url = window.location.href;
if (url.indexOf("orderCategoryManage") > 0
		|| url.indexOf("orderCategoryEdit") > 0) {
	$("#order").addClass("active");
	$("#orderCategoryManage").addClass("active");
} else if (url.indexOf("orderManage") > 0 || url.indexOf("orderEdit") > 0) {
	$("#order").addClass("active");
	$("#orderManage").addClass("active");
}

// 提示条配置
/*
toastr.options = {
	"closeButton" : true,
	"debug" : false,
	"progressBar" : true,
	"preventDuplicates" : false,
	"positionClass" : "toast-top-right",
	"onclick" : null,
	"showDuration" : "400",
	"hideDuration" : "1000",
	"timeOut" : "7000",
	"extendedTimeOut" : "1000",
	"showEasing" : "swing",
	"hideEasing" : "linear",
	"showMethod" : "fadeIn",
	"hideMethod" : "fadeOut"
}*/
