## Let's Go to Cinema

Proje fikri : **Pamukkale Üniversitesi CENG - 2017**

- Sistemde *iki tür* kullanıcı bulunmaktadır

* **Kullanıcılar:**
  * **Adminler**
  * **Müşteriler (Üyeler)**

- Her kullanıcı sisteme kullanıcı adı ve şifre ile giriş yapacak.
  - Kullanıcılar sisteme üye olabilmeliler. Aynı zamanda admin tarafından da sisteme dahil edilebilrler.
- Adminler için bir kayıt ekranı zorunluluğu yok. Opsiyonel olarak admin paneline bu özellik eklenebilir.

- Her grubun **rolleri aşağıdaki** gibidir:

#### Admin :

- Admin salon ekleyebilir ve salondaki sıra sayısı, her sıradaki koltuk sayısı gibi bilgilerini girebilir.
  *(Salon oluşturma mantığının nesneye yönelik düşünülmesi tavsiye edilmektedir)*
- Admin film ekleyebilir ve bu flimle ilgili *prodüksiyon yılı, oyuncular, dil, yönetmen, çıkış tarihi, 2 boyutlu - 3 boyutlu, poster vs. gibi bilgileri girebilir.* (*Fragman eklemek* **bonus** olarak sayılacaktır)
- Admin salonlara film ve gösterim zamanı atama işlemi yapabilir.
- *Satılan* ve *boş* olan koltuklar **farklı renklerde** görünmelidir.
- Salon, film ve gösterim zamanları **güncellenebilir** olmalıdır.

#### Müşteri :

- Kullanıcı sisteme kullanıcı adını ve şifresini kullanarak girebilir.
- Kullanıcı salon ve koltuk bilgilerini, **film bilgilerini** *(poster vs.)*, filmin gösterim saatlerini **görebilir**.
- Kullanıcı istediği gösterim saatinde istediği salondaki koltuklar için bilet satın alma işlemlerini yapabilir. *(önceden satılmamışsa)*
- Müşteriler almış olduğu bileti **iptal** edebilirler.**(Film gösteriminden 2 gün önceye kadar para iadesi yapılırken; Film gösterimine 2 günden az kalması takdirinde para iadesi yapılmaz.)**
- Kullanıcı **istediği kriterlere** göre(yönetmen, oyuncu, film adı, salon adı, gösterim saati vs.) **film arama** işlemi yapabilir.
- 3 boyutlu filmler için **3-D gözlük** istenip istenmediği sorulmalıdır. İsteniyorsa bilet tutarına ek olarak **3-D gözlük kiralama ücreti** eklenmelidir.
- Bilet satış veya rezervazyonundan sonra işleme ait tüm bilgiler ekranda listelenir.**(İşlem Özeti)**

#### Proje son teslim tarihi:

*Projenin süresi 10 gündür. **14 Haziran (23:59)** tarihine kadar bu klasör altına **IsimSoyisim** şeklinde alt-klasör oluşturarak yüklemeniz beklenmektedir. Esinlenmenin olmaması için lütfen en erken **12 Haziran** tarihinde yükleyiniz.*  

**!** Proje hakkında aklınıza takılan bir yer var ise;  
&nbsp;&nbsp;&nbsp;&nbsp; Üyeler - [Soru&Cevap](https://github.com/orgs/java-util-help/teams/q-a)  
&nbsp;&nbsp;&nbsp;&nbsp; Üye olmayanlar, proje üzerinde **issue** açarak sorabilirler - [Issues](https://github.com/java-util-help/projects/issues)

> İsteğe bağlı olarak, hazırlamış olduğunuz proje hakkında kısa bir rapor oluşturabilirsiniz.
