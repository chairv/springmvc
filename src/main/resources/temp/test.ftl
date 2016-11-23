<h4>提现数据</h4>

<#list items as item>
    <#list item?keys as key>
    <div>${key}</div>
    <div>${item[key]}</div>
    </#list>
</#list>