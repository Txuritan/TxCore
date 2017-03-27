var time = new Date().getHours();
if ((time >= 20 && time <= 23) || (time >= 0 && time <= 4)) {
    makeCssLink('dark');
} else {
    makeCssLink('light');
}

function makeCssLink(theme) {
    var link = document.createElement('link');
    link.href = '/core/wiki/css/' + theme + '.css';
    link.rel = 'stylesheet';
    link.type = 'text/css';
    link.media = 'all';
    document.getElementsByTagName('head')[0].appendChild(link);
}