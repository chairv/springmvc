<h4>提现数据</h4>
<table>
    <thead>
    <th>
    <td>统计日期</td>
    <td>提现金额</td>
    <td>提现数</td>
    <td>提现成功数</td>
    <td>等初审数</td>
    <td>等复审数</td>
    </th>
    </thead>

    <tbody>
    <tr>
        <#if limit = -1>
            <td>无限额</td>
         <#else>
             <td>${limit?number}</td>
        </#if>
        <td>${date?string("yyyy-MM-dd")}</td>
    </tr>
    </tbody>
</table>