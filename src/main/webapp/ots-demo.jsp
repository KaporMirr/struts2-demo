<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>optiontransferselect Demo</title>
    <link rel="stylesheet" href="ots-demo.css"/>
    <script src="ots-demo.js" type="application/javascript" charset="UTF-8"></script>
</head>
<body>
    <p>
        <input type="button" onclick="location.reload()" value="Browser Reload">
        <input type="button" onclick="window.location.assign('<s:url action="otsDemo" />')" value="Self">
    </p>
    <h2>optiontransferselect Demo</h2>
    <s:form action="otsSave" name="otsSaveForm">
        <s:optiontransferselect
                leftTitle="Programming Languages"
                list="notSelected"
                name="notSelected"
                value="emptyList"
                rightTitle="My Selection for 2022"
                doubleList="selected"
                doubleName="selected"
                doubleValue="emptyList"
                id="idLeft"
                doubleId="idRight"
                ondblclick="moveSelectedOptions(document.getElementById('idLeft'), document.getElementById('idRight'), false, '');"
                doubleOndblclick="moveSelectedOptions(document.getElementById('idRight'), document.getElementById('idLeft'), false, '');"
                leftUpLabel="#leftUp"
                leftDownLabel="#leftDown"
                rightUpLabel="#rightUp"
                rightDownLabel="#rightDown"
                addToLeftLabel="==◀"
                addToRightLabel="==▶"
                addAllToLeftLabel="==◀◀"
                addAllToRightLabel="==▶▶"
                selectAllLabel="==◀ ✱ ▶">
        </s:optiontransferselect>
        <s:submit value="💾 Save" id="save-button"
                onclick="soften('idLeft');
                         soften('idRight');
                         selectAllOptions(document.getElementById('idLeft'));
                         selectAllOptions(document.getElementById('idRight'));" />
    </s:form>
    <p>You selected: <s:property value="lastSelected" /></p>
    <p>Number of remaining languages: <s:property value="remaining" /></p>
    <p><input type="button" onclick="window.location.assign('<s:url action="index" />')" value="🏠 Back to Main Page"></p>
</body>
</html>
