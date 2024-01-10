catalina.2023-03-26.log
catalina1.out-20230326.gz
catalina2.out-20230326.gz

/home/suser



catalina2.out-20230325.gz
catalina2.out-20230326.gz



cp -ap catalina2.out-20230325.gz /home/suser/catalina2.out-20230325.gz
cp -ap catalina2.out-20230326.gz /home/suser/catalina2.out-20230326.gz


cp -ap catalina1.out-20230325.gz /home/suser/catalina1.out-20230325.gz



cp -ap catalina1.out-20230326.gz /home/suser/catalina1.out-20230326.gz


java -jar -Dspring.profiles.active=sandbox /app/cmsApi/cmsApi-1.2.jar



curl -X POST -H 'Content-type: text/xml'  -d '<SMSDATA>
    <DATA>
        <RECEIVER>01028217207</RECEIVER>
        <SENDER>02-6375-8000</SENDER>
        <MESSAGE>121212</MESSAGE>
        <SENDERID></SENDERID>
        <SENDERIPADD></SENDERIPADD>
        <TYPE>SMS</TYPE>
    </DATA>
    </SMSDATA>' https://g.kakaoent.com/WebSite/smsSend.aspx