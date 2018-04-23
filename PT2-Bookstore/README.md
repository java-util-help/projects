## BookStore

Proje fikri: [@btnerylmz](https://github.com/btnerylmz)  

- Projenin 11 class'tan oluşturulması tavsiye edilir.
	Bunlar;  

	* **Section (Abstract)**  
		*  **Sci-Fi**
		*  **Fantastic**
		*  **Philosophy**
		*  **Literature**  
	* **Employee (Abstract)**
		* **Staff**
		* **SuperVisor**
	* **BookStore**  
	* **BookStoreTest**  
	* **Book**


- BookStore uygulamasının aşağıdaki gibi olması istenmektedir.  

	**Section class'ı**; bölümün kitap sayısı, bölüm çalışanlarını vb. içermelidir. *Abstract class* biçiminde yazılmalıdır.

	**Section subclass'ları**nda; her subclass'ta farklı türde bir indirim uygulanması istenmektedir ve her bölümün çalışanı olmalıdır. O bölümden kitap alınacağı zaman *"Merhaba ben Batın. Hangi kitabı almak istersiniz?"* gibi bir mesaj ekrana bastırılmalıdır.

	**Employee class'ı**nda; çalışanın adı, soyadı, cinsiyeti(enum tipi önerilir), saatlik maaşı, haftalık çalıştığı saat ve çalıştığı bölüm bulunmalıdır. *Abstract class* biçiminde yazılmalıdır. Maaşları hesaplama metodu olmalıdır. (Haftalık 40 saati geçen çalışanlar her saat için 1.5 kat ücret alabilirler.)

	**Employee subclass'ları**nda; çalışanların maaş hesaplamaları farklı olması için *override* ederek method'lar oluşturulmalıdır. (Belli bir maaş sabit maaşı olur üstüne diğer çalısanlar gibi saatlik maaş alır.)

	**BookStore class'ı**nda; Mağaza ismi olmalıdır. Kitap alma(toptancıdan), kitap satma(müşteriye), kitap görüntüleme, bölüm görüntüleme, çalışan ekleme, çalışan çıkarma, çalışan görüntüleme metotları bulunmalıdır.

	**BookStoreTest class'ı**, menü içermelidir.

	**Book class'ı**nda kitabın ismi ve fiyatı olmalıdır.
	
	**Note**; Hiçbir bölümde kitap sınırlaması olmamalıdır. Gerektiğinde 100000 tane bilim kurgu kitabı girilebilir şekilde bi oluşturulması istenmektedir.(Öneri: ArrayList)

#### Proje son teslim tarihi:

*Projenin süresi 1 haftadır. **1 Mayıs (23:59)** tarihine kadar bu klasör altına **IsimSoyisim** şeklinde alt-klasör oluşturarak yüklemeniz beklenmektedir. Esinlenmenin olmaması için lütfen en erken **28 Nisan** tarihinde yükleyiniz.*  

**!** Proje hakkında aklınıza takılan bir yer var ise;  
&nbsp;&nbsp;&nbsp;&nbsp; Üyeler - [Soru&Cevap](https://github.com/orgs/java-util-help/teams/q-a)  
&nbsp;&nbsp;&nbsp;&nbsp; Üye olmayanlar, proje üzerinde **issue** açarak sorabilirler - [Issues](https://github.com/java-util-help/projects/issues)

> İsteğe bağlı olarak, hazırlamış olduğunuz proje hakkında kısa bir rapor oluşturabilirsiniz.
