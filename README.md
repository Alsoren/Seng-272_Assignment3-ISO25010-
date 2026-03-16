Bu projede metrik skorları `calculateScore()` metodu ile hesaplanmaktadır.
Ölçülen değerler, metrik yönüne göre (higher veya lower) normalize edilerek 1 ile 5 arasında bir kalite skoruna dönüştürülür.
Hesaplama sırasında değerlerin belirlenen minimum ve maksimum aralıkta değerlendirilmesi sağlanır ve sonuçlar 1–5 aralığına sınırlandırılır.
Proje gereksinimine göre skorların yalnızca 0.5 adımlarla verilmesi gerektiğinden,
hesaplanan değerler en yakın 0.5’e yuvarlanmaktadır (`Math.round(score * 2.0) / 2.0`).
Bu sayede tüm metrikler aynı ölçek üzerinde değerlendirilebilir hale gelir.
pdfdeki örnek çıktıdan farklı sonuç aldığım için kendi testlerimde açıklama gereksiniminde bulundum
