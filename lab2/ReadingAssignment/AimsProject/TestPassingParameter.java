
public class TestPassingParameter {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}

// 1. Tại sao sau khi gọi swap(jungleDVD, cinderellaDVD), tiêu đề của hai đối tượng vẫn giữ nguyên?
//Lý do:
//Trong Java, tham số được truyền theo cơ chế "pass-by-value" (truyền theo giá trị).
//Khi gọi swap(jungleDVD, cinderellaDVD), giá trị của tham chiếu (reference) của jungleDVD và cinderellaDVD được sao chép vào hai tham số o1 và o2 của phương thức swap.
//Bên trong phương thức, o1 và o2 chỉ thay đổi địa chỉ tham chiếu, nhưng bản thân các đối tượng gốc bên ngoài không bị thay đổi.
// 2. Tại sao sau khi gọi changeTitle(jungleDVD, cinderellaDVD.getTitle()), tiêu đề của jungleDVD thay đổi?
//Lý do:
//jungleDVD là một tham chiếu đến đối tượng DigitalVideoDisc, khi truyền vào phương thức changeTitle, nó vẫn là một bản sao của tham chiếu, nhưng cả hai bản sao cùng trỏ đến cùng một đối tượng trên heap.
//Phương thức changeTitle thay đổi trực tiếp dữ liệu bên trong đối tượng được tham chiếu (chính là jungleDVD).
