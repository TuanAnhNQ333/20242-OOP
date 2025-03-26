
public class TestPassingParameter {

    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        // Swap titles instead of objects
        swapTitles(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    // Swap titles of the DVDs
    public static void swapTitles(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        String tmpTitle = dvd1.getTitle();
        dvd1.setTitle(dvd2.getTitle());
        dvd2.setTitle(tmpTitle);
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        dvd.setTitle(title);
    }
}

/*
1. After the call of swap(jungleDVD, cinderellaDVD) why does the title of these two
objects still remain?

Lý do:
Trong Java, tham số được truyền theo cơ chế "pass-by-value" (truyền theo giá trị).
Khi truyền đối tượng vào phương thức, nó chỉ truyền bản sao của địa chỉ đối tượng. Hoán đổi trong phương thức swap() chỉ hoán đổi bản sao,
không ảnh hưởng đến đối tượng gốc bên ngoài.


2. After the call of changeTitle(jungleDVD, cinderellaDVD.getTitle()) why is
the title of the JungleDVD changed?


Lý do:
Title của jungleDVD thay đổi vì changeTitle() trực tiếp thay đổi giá trị thuộc tính title của đối tượng thông qua setTitle(), 
không phải thay đổi địa chỉ đối tượng như swap().

*/
