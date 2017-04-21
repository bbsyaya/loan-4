<!DOCTYPE html [
<!ENTITY nbsp "&#160;"> 
]>
<html lang="UTF-8">
<head>
<title>流量贷授信协议</title>
<style>
body{font-family: SimSun;line-height:150%}
p {text-indent:2em;}
p.underline {text-decoration:underline;}
span.underLine {border-bottom:1px solid #000;
      padding:0 1px;}
.bold {
       font-weight:bold;
      }
.img {
      text-align:center;
      margin-top: 300px;
      margin-bottom: 150px;}
.img img{width: 50%;}
.title {text-align: center;
      font-size: 40pt;
      margin-bottom: 30px;
      font-weight: bold;}

</style>
</head>

<body>
<div class="img" ><img src="hrbbLogo.png" /></div>
<div class="title">贷款结清证明</div>


<section>
<p>
借款人<span class="underLine">    ${custName}    </span>(身份证号码为<span class="underLine">    ${idCard}    </span>)在我行互联网金融事业部贷款
<span class="underLine">${money}</span>元，业务编号<span class="underLine">${receiptId}</span>,贷款发放日期为<span class="underLine">    ${beginYear}    </span>年<span class="underLine">    ${beginMonth}     </span>月<span class="underLine">     ${beginDay}    </span>日,已于
<span class="underLine">    ${endYear}    </span>年<span class="underLine">    ${endMonth}     </span>月<span class="underLine">     ${endDay}    </span>日,结清贷款本息。
</p>
<p>特此证明</p>

<div style="text-align:right">
银行盖章：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/>
<span class="underLine">    ${endYear}    </span>年<span class="underLine">    ${endMonth}     </span>月<span class="underLine">     ${endDay}    </span>日<br/>
</div>

</section>
</body>
</html>
