
//封装自定义tree方法
function treeInit(keyId, elementId){
    var obj = {
        current: $("#" + elementId),
        tree: $("#" + elementId + "Tree"),
        text: $("#" + elementId + "Text"),
        div: $("#" + elementId + "Div"),
    }
    obj.div.css({"display":"block"});
    $.fn.zTree.init(obj.tree,{
        async: {
            enable: true,
            autoParam: ["id=pid"],
            otherParam: ["keyId", keyId],
            url: "/classValue/tree"
        },
        callback: {
            onClick: function(event, treeId, treeNode) {
                obj.current.val(treeNode.id);
                obj.text.val(treeNode.name);
                obj.div.css({"display":"none"});
            }
        }
    });
}