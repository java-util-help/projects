## BookStore

Proje fikri: [@btnerylmz](https://github.com/btnerylmz)  

- Projenin 11 class'tan oluşturulması tavsiye edilir.
	Bunlar;  

	&nbsp;&nbsp;&nbsp;&nbsp; **1)** Section(Abstract)
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **a)** Sci-Fi
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **b)** Fantastic
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **c)** Philosophy
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **b)** Literature
	&nbsp;&nbsp;&nbsp;&nbsp; **2)** Employee(Abstract)
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **a)** Staff
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **b)**	SuperVisor
	&nbsp;&nbsp;&nbsp;&nbsp; **4)** BookStore
	&nbsp;&nbsp;&nbsp;&nbsp; **5)** BookStoreTest
	&nbsp;&nbsp;&nbsp;&nbsp; **6)** Kitap

- BookStore uygulamasının aşağıdaki gibi olması istenmektedir.  

	**Section class**'ı Bölümün adını,kitap sayısı, bölümde çalışanlar vb. içermelidir.Abstract class biçiminde yazılmalıdır.

	**Section subclassları** : Her subclassta farklı türde bir indirim uygulanması istenmektedir ve her bölümün çalışanı olmalıdır(o bölümden kitap alınacağı zaman çalşanın ismi(Merhaba ben Batın. Hangi kitabı istersiniz? gibi) ekrana bastırılmalıdır).

	**Employee class**'ında çalışanın adı,soyadı,cinsiyeti(enum),maaşı,haftalık çalıştığı saat ve çalıştığı bölüm bulunmalıdır. Abstract class biçiminde yazılmalıdır. Maaşları hesaplama metodu olmalıdır. (haftalık 40 saati geçen her saat için 1.5 kat ücret alırlar).

	**Employee subclassları** : Çalışanların maaş hesaplamaları farklı olmalıdır.(override) SuperVisor 25 saat üstüne 1.8 kat ücret alır.

	**BookStore class**'ında kitap alma(toptancıdan),kitap satma(müşteriye),kitap görüntüleme,bölüm görüntüleme,çalışan eklememe,çalışan çıkarma,çalışan çıkarma metotları bulunmalıdır.

	**BookStoreTest class**'ında da menü olmalıdır.



#### Proje son teslim tarihi:

>*Projenin son yükleme günü. **1 Mayıs (23:59)**
 Esinlenmenin olmaması adına en erken **28 Nisan** tarihinde yükleyiniz.
Bu klasör altına **IsimSoyisim** şeklinde alt-klasör oluşturarak yüklemeniz beklenmektedir.*

 İsteğe bağlı olarak, hazırlamış olduğunuz proje hakkında kısa bir rapor oluşturabilirsiniz.
