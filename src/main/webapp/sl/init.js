/**
 * desc: Common Footer Script
 * author: tony dream
 * date：2014/12/29
 */
$(function() {
	var WebMain = {
        init: function () {
            this.injectCode();
        },
        /**
         * 插件代码
         * @return {[type]} [description]
         */
        injectCode: function () {
            var buf = [];
            $('.footer-banner').html(buf.join(''));
        }
    }

	WebMain.init();
});