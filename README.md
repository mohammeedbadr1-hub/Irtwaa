# ارتواء — مشروع Android (بناء APK تلقائي)

## بناء APK على GitHub Actions
1. فك ضغط المشروع.
2. أنشئ repository على GitHub.
3. ارفع **كل محتويات المجلد** إلى repository (بما فيها مجلد `.github/workflows`).
4. افتح تبويب Actions في GitHub، وافتح workflow `Build Irtwaa APK`.
5. انتظر حتى تظهر علامة نجاح خضراء. افتح run ثم قسم Artifacts ونزّل `irtwaa-debug-apk`.
6. فك ضغط Artifact وثبّت `app-debug.apk` على Android.

## تنبيه
هذه نسخة أولية من التطبيق. APK الناتج هو debug build للتجربة وليس إصدار متجر. يجب اختبار الوظائف على الجهاز؛ بعض ميزات التذكير قد تتأثر بقيود البطارية/الأذونات. لا توجد صلاحية INTERNET في Manifest.
