function getMd(mdName, successFun) {
    doAjax("get", {
        url: "./md/" + mdName,
        success: function (res) {
            successFun(marked.parse(res))
        }
    })
}

function doAjax(ajaxType, config) {
    $.ajax({
        url: config.url,
        type: ajaxType,
        success: function (result) {
            config.success(result);
        },
        error: function (err) {
            console.log(err);
        }
    })
}