${(amount/100)?string('#.##')}

<#--不存在默认值，然后转义计算处理-->
${(amountNull!0/100)?string('#.##')}

${((amountStr?number!0)/100)?string('#.##')}