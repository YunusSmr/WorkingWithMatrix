/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson;

import java.util.Scanner;

/**
 *
 * @author yunus
 */
public class Matrix {

    /**
     * @param args
     * @file Matrix.java
     * @description Kullanıcı tarafından oluştutulan random matrisin istenilen
     * yönde ve sayıda kenar elemanlarını döndüren program
     * @assignment Proje-2
     * @date 30 Kasım 2020
     * @author Yunus SÜMER yunus.sumer@stu.fsm.edu.tr
     */
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        System.out.println("Matrix Döndürme Uygulaması'na Hoşgeldiniz.");
        int[] menu = {5, 5, -1, 100, 2};
        int choıce = 0;
        int[][] matrix;
        /*
        Program menu-based olarak yapıldı.
        Programın daha düzgün çalışabilmesi için 6 adet method yazıldı.
         */
        while (choıce != 53) {
            matrix = new int[menu[0]][menu[1]];
            PrıntMenu();
            choıce = (int) user.next().charAt(0);
//             Girilen ifadenin ilk indisi alınıp integera cast edilir.
            switch (choıce) {
//                Menu tabanlı bir yapı için switch-case yapısı kullanıldı.
                case 49:
                    boolean test = true;
                    while (test) {
                        for (int i = 0; i < menu.length; i++) {
                            if (menu[i] != 0) {
                                test = false;
                            }
                        }
                    }
                    if (!test) {
//                        Gerekli şartları sağlayan işlemler metotlar sayesinde hesaplandı ve yazdırıldı.
                        matrix = RandomMatrıx(matrix, menu);
                        System.out.println("Matrix'in işlemden önceki hali:");
                        PrıntMatrıx(matrix);
                        System.out.print("Yapılacak olan işlem:");
                        PrıntArray(menu);
                        ShıftToDırect(matrix, menu);
                        for (int i = 0; i < menu[4]; i++) {
                            matrix = ShıftToDırect(matrix, menu);
                        }
                        System.out.println("Matrix'in işlemden sonraki hali:");
                        PrıntMatrıx(matrix);
                    } else {
                        System.out.println("Bu şekilde bir işlem yapılamaz.","UTF-8");
                    }
                    break;
                case 50:
                    CorrectInput(choıce, menu);
                    break;
                case 51:
                    CorrectInput(choıce, menu);
                    break;
                case 52:
                    CorrectInput(choıce, menu);
                    break;
                case 53:
                    choıce = 53;
                    break;
                default:
                    System.out.println("Hatalı bir seçim yaptınız.Lütfen var olan seçeneklerden bir tanesini seçiniz.");
                    break;
            }
        }
        System.out.println("Uygulamamızı tercih ettiğiniz için teşekkür eder iyi günler dileriz.");
    }

    static void PrıntMatrıx(int[][] p_matrıx) {

        for (int i = 0; i < p_matrıx.length; i++) {
            for (int j = 0; j < p_matrıx[i].length; j++) {
                System.out.print(p_matrıx[i][j] + " ");
            }
            System.out.println("");

        }
    }

    static int[][] RandomMatrıx(int[][] p_matrıx, int[] p_menu) {
//        Kullanıcı girdiği değerler ile random matris oluşturuluyor.
        p_matrıx = new int[p_menu[0]][p_menu[1]];
        for (int i = 0; i < p_menu[0]; i++) {
            for (int j = 0; j < p_menu[1]; j++) {
                p_matrıx[i][j] = (int) (Math.random() * p_menu[3]);

            }
        }

        return p_matrıx;

    }

    static int[][] ShıftToDırect(int[][] p_matrıx, int[] p_menu) {
//        Kullanıcının matrisi istediği yönde döndürebilmesini sağlayan metottur.
        int[][] tmpMatrıx = new int[p_matrıx.length][p_matrıx[0].length];
        if (p_menu[2] == -1) {
            for (int i = 0; i < p_matrıx.length; i++) {
                for (int j = 0; j < p_matrıx[0].length; j++) {
                    if (i == 0 && j != p_matrıx[0].length - 1) {
                        tmpMatrıx[i][j + 1] = p_matrıx[i][j];

                    } else if (i == p_matrıx.length - 1 && j != 0) {
                        tmpMatrıx[i][j - 1] = p_matrıx[i][j];
                    } else if (j == 0 && i != 0) {
                        tmpMatrıx[i - 1][j] = p_matrıx[i][j];
                    } else if (j == p_matrıx[1].length - 1 && i != p_matrıx.length - 1) {
                        tmpMatrıx[i + 1][j] = p_matrıx[i][j];

                    }
                }
            }

        } else {
            for (int i = 0; i < p_matrıx.length; i++) {
                for (int j = 0; j < p_matrıx[0].length; j++) {
                    if (i == 0 && j != 0) {
                        tmpMatrıx[i][j - 1] = p_matrıx[i][j];

                    } else if (i == p_matrıx.length - 1 && j != p_matrıx[0].length - 1) {
                        tmpMatrıx[i][j + 1] = p_matrıx[i][j];
                    } else if (j == 0 && i != p_matrıx.length - 1) {
                        tmpMatrıx[i + 1][j] = p_matrıx[i][j];
                    } else if (j == p_matrıx[0].length - 1 && i != 0) {
                        tmpMatrıx[i - 1][j] = p_matrıx[i][j];

                    }
                }
            }
        }

        for (int i = 1; i < p_matrıx.length - 1; i++) {
            for (int j = 1; j < p_matrıx[0].length - 1; j++) {
                tmpMatrıx[i][j] = p_matrıx[i][j];
            }
        }
        return tmpMatrıx;
    }

    static void PrıntMenu() {

        System.out.println("1. Uygulamayı Çalıştır(1):");
        System.out.println("2. Matris oluştur(2):");
        System.out.println("3. Direction(3):");
        System.out.println("4. Step number(4):");
        System.out.println("5. Exit(5):");
        System.out.print("Seçenek:");

    }

    static void PrıntArray(int[] p_array) {

        System.out.print("(");
        for (int i = 0; i < p_array.length; i++) {
            System.out.print(p_array[i] + ",");
        }
        System.out.println(")");
//        System.out.println("");
    }

    static int[] CorrectInput(int p_choıce, int[] p_array) {
//        Kullanıcı girdiği değerler string olarak alındı.Bu değerler ASCII Tablosu yardımı ile int'e cast edildi.Doğru değerlerin  sağlamak için ilgili yapılar yazıldı.
        Scanner user = new Scanner(System.in);
        boolean test = true;
        while (test) {
            if (p_choıce > 48 && p_choıce < 54) {
                System.out.println("Girdiğiniz verinin ilk basamağı baz alındı.");
                test = false;
            } else {
                System.out.println("Hatalı seçim yaptınız..Lütfen doğru bir seçenek giriniz!");
                System.out.print("Seçenek:");
                p_choıce = (int) user.next().charAt(0);
            }
        }
        switch (p_choıce) {
            case 50:
                System.out.print("Lütfen Oluşturmak istediğiniz matrix'in satır sayısını giriniz:");
                p_array[0] = user.nextInt();
                System.out.print("Lütfen Oluşturmak istediğiniz matrix'in sütun sayısını giriniz:");
                p_array[1] = user.nextInt();
                test = true;
                while (test) {
                    if (p_array[0] > 1 && p_array[1] > 1) {
                        test = false;
                    } else {
                        System.out.println("Hatalı veri girdiniz.Böyle bir matrix oluşturulamaz!");
                        System.out.print("Lütfen Oluşturmak istediğiniz matrix'in satır sayısını giriniz:");
                        p_array[0] = user.nextInt();
                        System.out.print("Lütfen Oluşturmak istediğiniz matrix'in sütun sayısını giriniz:");
                        p_array[1] = user.nextInt();
                    }
                }

                System.out.print("Lütfen oluşturulacak olan random matrisin elemanlarının 0 ile kaç değerleri\n"
                        + "arasında olması gerektiğini belirtiniz:");
                p_array[3] = user.nextInt();
                test = true;
                while (test) {
                    if (p_array[3] > 0) {
                        test = false;
                    } else {
                        System.out.println("Hatalı veri girdiniz..Böyle bir üst sınır belirlenemez!");
                        System.out.print("Lütfen oluşturmuş olacağınız random matris'in üst sınırı'nı belirleyiniz:");
                        p_array[3] = user.nextInt();
                    }
                }
                break;
            case 51:
                System.out.print("Lütfen Oluşturmuş olduğunuz matris'in hangi yöne doğru döndürmek istediğinizi seçiniz"
                        + "Saat yönü için (-1) ve saat yönü tersi için (1) seçiniz: ");
                p_array[2] = user.nextInt();
                test = true;
                while (test) {
                    if (p_array[2] == 1 || p_array[2] == -1) {
                        test = false;
                    } else {
                        System.out.println("Hatalı veri girdiniz..Lütfen 1 veya -1 arasında seçim yapınız!");
                        System.out.print("Oluşturmuş olduğunuz matris'in dönme yönü:");
                        p_array[2] = user.nextInt();
                    }
                }
                break;
            case 52:
                System.out.print("Lütfen matris elemanlarının kaç adet\n"
                        + "döndürüleceğini belirtiniz:");
                p_array[4] = user.nextInt();
                test = true;
                while (test) {
                    if (p_array[4] > 0) {
                        test = false;
                    } else {
                        System.out.println("Hatalı veri girdiniz.Böyle bir döndürme işlemi yapılamaz!");
                        System.out.print("Lütfen oluşturmuş olacağınız random matris'in kaç adet döndürüleceğini belirleyiniz:");
                        p_array[4] = user.nextInt();
                    }
                }
                break;
        }
        return p_array;
    }
}
