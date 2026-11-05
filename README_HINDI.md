# SHIVAM VPN PANEL — Starter Project

यह एक शुरुआती Android project है: dark home screen और Android VPN permission request।
यह अभी वास्तविक VPN नहीं चलाता और CONNECTED का झूठा status नहीं दिखाता।

## जरूरी चीजें
- Android Studio या ऐसा Android IDE जो Gradle Kotlin DSL और Android Gradle Plugin 8.7.3 सपोर्ट करे।
- JDK 17
- Android SDK Platform 35
- Android 9+ डिवाइस

## Build
1. ZIP extract करें।
2. Android Studio में इस folder को Open करें।
3. Gradle sync पूरा होने दें।
4. Build > Build APK(s) चुनें।
5. APK install करके UI और VPN permission flow जाँचें।

## असली VPN चालू करने से पहले
- अपने या अधिकृत VPN provider का server endpoint और configuration लें।
- WireGuard Android tunnel backend को उसकी आधिकारिक integration guide के अनुसार जोड़ें:
  https://www.wireguard.com/embedding/
- Private key को source code, screenshots या public repository में कभी न डालें।
- Tunnel को तभी CONNECTED दिखाएँ जब backend active tunnel की पुष्टि करे।
- इस starter की ShivamVpnService अभी जानबूझकर कोई traffic route नहीं करती।

## मोबाइल पर
CodeOnTheGo जैसे मोबाइल IDE में खोलने से पहले जाँच लें कि वह इस Gradle/Android plugin version को support करता है। यदि sync न हो, Android Studio on a computer अधिक भरोसेमंद विकल्प है।
