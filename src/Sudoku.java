import java.util.Scanner;

public class Sudoku {

    static Scanner sc = new Scanner(System.in);
    static Integer[][] Sudoku = new Integer[9][9];
    static int NumJogadores = 0;

    public static void main(String[] args) {

        limpaSudoku();

        System.out.println("Número de Jogadores: ");
        NumJogadores = sc.nextInt();

        String[] Nomes = new String[NumJogadores];

        for (int i = 0; i < NumJogadores; i++) {

            System.out.println("Informe o nome do Jogador " + (i + 1) + ": ");
            Nomes[i] = sc.next();
            sc.nextLine();

        }
        escreveSudoku(Nomes);

    }
    public static void limpaSudoku(){

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                Sudoku[i][j] = 0;

            }

        }

    }


    public static void escreveSudoku(String[] Nomes) {

        for (int j = 0; j < NumJogadores; j++) {

            int l = 0;
            int c = 0;
            int NumeroDesejado = 0;
            int NumeroDeJogadas = 0;
            boolean verificacao;
            while (NumeroDeJogadas != 85) {
                escreveTabela();

                System.out.println("Jogador " + Nomes[j] + " em qual coluna deseja jogar:");
                c = sc.nextInt();

                System.out.println("Jogador " + Nomes[j] + " em qual linha deseja jogar:");
                l = sc.nextInt();

                System.out.println("Jogador " + Nomes[j] + " qual número deseja colocar: ");
                NumeroDesejado = sc.nextInt();

                if (Sudoku[l][c] == 0) {
                    Sudoku[l][c] = NumeroDesejado;
                    NumeroDesejado = 0;
                    NumeroDeJogadas++;
                }
                else {
                    int escolha = 0;
                        System.out.println("Você deseja trocar esse número | 1-Sim 2-Não: ");
                        escreveTabela();
                        escolha = sc.nextInt();
                        if (escolha == 1) {
                            Sudoku[l][c] = NumeroDesejado;
                            NumeroDesejado = 0;
                            NumeroDeJogadas++;
                        }
                }

            }
            verificacao = verificaSudoku();
            if(verificacao == true){

                System.out.println("O Sudoku de "+Nomes[j]+" está correto");
                escreveTabela();
                limpaSudoku();

            }
            else if(verificacao == false){

                System.out.println("O Sudoku de "+Nomes[j]+" está errado");
                escreveTabela();
                limpaSudoku();

            }
        }

    }

    public static void escreveTabela() {


        for (int j = 0; j < 9; j++) {

            System.out.printf(Sudoku[j][0] + " " + Sudoku[j][1] + " " + Sudoku[j][2] + " | " + Sudoku[j][3] + " " + Sudoku[j][4] + " " + Sudoku[j][5] + " | " + Sudoku[j][6] + " " + Sudoku[j][7] + " " + Sudoku[j][8] + "\n");
            if (j == 2 || j == 5) {
                System.out.println("---------------------");
            }

        }


    }

    public static boolean verificaSudoku() {

        boolean correta = false;
        for (int l = 0; l < 9; l++) {
            if ((Sudoku[l][0] + Sudoku[l][1] + Sudoku[l][2] + Sudoku[l][3] + Sudoku[l][4] + Sudoku[l][5] + Sudoku[l][6] + Sudoku[l][7] + Sudoku[l][8]) != 45) {

                correta = false;

            } else if ((Sudoku[l][0] + Sudoku[l][1] + Sudoku[l][2] + Sudoku[l][3] + Sudoku[l][4] + Sudoku[l][5] + Sudoku[l][6] + Sudoku[l][7] + Sudoku[l][8]) == 45) {

                correta = true;

            }
        }
        for (int c = 0; c < 9; c++) {
            if ((Sudoku[0][c] + Sudoku[1][c] + Sudoku[2][c] + Sudoku[3][c] + Sudoku[4][c] + Sudoku[5][c] + Sudoku[6][c] + Sudoku[7][c] + Sudoku[8][c]) != 45) {

                correta = false;

            } else if ((Sudoku[0][c] + Sudoku[1][c] + Sudoku[2][c] + Sudoku[3][c] + Sudoku[4][c] + Sudoku[5][c] + Sudoku[6][c] + Sudoku[7][c] + Sudoku[8][c]) == 45) {

                correta = true;

            }
        }
        //Primeiro Quadrado
        if ((Sudoku[0][0] + Sudoku[0][1] + Sudoku[0][2] + Sudoku[1][0] + Sudoku[1][1] + Sudoku[1][2] + Sudoku[2][0] + Sudoku[2][1] + Sudoku[2][2]) != 45) {

            correta = false;

        } else if ((Sudoku[0][0] + Sudoku[0][1] + Sudoku[0][2] + Sudoku[1][0] + Sudoku[1][1] + Sudoku[1][2] + Sudoku[2][0] + Sudoku[2][1] + Sudoku[2][2]) == 45) {

            correta = true;

        }
        //Segundo Quadrado
        if ((Sudoku[0][3] + Sudoku[0][4] + Sudoku[0][5] + Sudoku[1][3] + Sudoku[1][4] + Sudoku[1][5] + Sudoku[2][3] + Sudoku[2][4] + Sudoku[2][5]) != 45) {

            correta = false;

        } else if ((Sudoku[0][3] + Sudoku[0][4] + Sudoku[0][5] + Sudoku[1][3] + Sudoku[1][4] + Sudoku[1][5] + Sudoku[2][3] + Sudoku[2][4] + Sudoku[2][5]) == 45) {

            correta = true;

        }
        //Terceiro Quadrado
        if ((Sudoku[0][6] + Sudoku[0][7] + Sudoku[0][8] + Sudoku[1][6] + Sudoku[1][7] + Sudoku[1][8] + Sudoku[2][6] + Sudoku[2][7] + Sudoku[2][8]) != 45) {

            correta = false;

        } else if ((Sudoku[0][6] + Sudoku[0][7] + Sudoku[0][8] + Sudoku[1][6] + Sudoku[1][7] + Sudoku[1][8] + Sudoku[2][6] + Sudoku[2][7] + Sudoku[2][8]) == 45) {

            correta = true;

        }


        //Quarto Quadrado
        if ((Sudoku[3][0] + Sudoku[3][1] + Sudoku[3][2] + Sudoku[4][0] + Sudoku[4][1] + Sudoku[4][2] + Sudoku[5][0] + Sudoku[5][1] + Sudoku[5][2]) != 45) {

            correta = false;

        } else if  ((Sudoku[3][0] + Sudoku[3][1] + Sudoku[3][2] + Sudoku[4][0] + Sudoku[4][1] + Sudoku[4][2] + Sudoku[5][0] + Sudoku[5][1] + Sudoku[5][2]) == 45) {

            correta = true;

        }
        //Quinto Quadrado
        if ((Sudoku[3][3] + Sudoku[3][4] + Sudoku[3][5] + Sudoku[4][3] + Sudoku[4][4] + Sudoku[4][5] + Sudoku[5][3] + Sudoku[5][4] + Sudoku[5][5]) != 45) {

            correta = false;

        } else if ((Sudoku[3][3] + Sudoku[3][4] + Sudoku[3][5] + Sudoku[4][3] + Sudoku[4][4] + Sudoku[4][5] + Sudoku[5][3] + Sudoku[5][4] + Sudoku[5][5]) == 45) {

            correta = true;

        }
        //Sexto Quadrado
        if ((Sudoku[3][6] + Sudoku[3][7] + Sudoku[3][8] + Sudoku[4][6] + Sudoku[4][7] + Sudoku[4][8] + Sudoku[5][6] + Sudoku[5][7] + Sudoku[5][8]) != 45) {

            correta = false;

        } else if ((Sudoku[3][6] + Sudoku[3][7] + Sudoku[3][8] + Sudoku[4][6] + Sudoku[4][7] + Sudoku[4][8] + Sudoku[5][6] + Sudoku[5][7] + Sudoku[5][8]) == 45) {

            correta = true;

        }


        //Sétimo Quadrado
        if ((Sudoku[6][0] + Sudoku[6][1] + Sudoku[6][2] + Sudoku[7][0] + Sudoku[7][1] + Sudoku[7][2] + Sudoku[8][0] + Sudoku[8][1] + Sudoku[8][2]) != 45) {

            correta = false;

        } else if((Sudoku[6][0] + Sudoku[6][1] + Sudoku[6][2] + Sudoku[7][0] + Sudoku[7][1] + Sudoku[7][2] + Sudoku[8][0] + Sudoku[8][1] + Sudoku[8][2]) == 45) {

            correta = true;

        }
        //Oitavo Quadrado
        if ((Sudoku[6][3] + Sudoku[6][4] + Sudoku[6][5] + Sudoku[7][3] + Sudoku[7][4] + Sudoku[7][5] + Sudoku[8][3] + Sudoku[8][4] + Sudoku[8][5]) != 45) {

            correta = false;

        }
        else if ((Sudoku[6][3] + Sudoku[6][4] + Sudoku[6][5] + Sudoku[7][3] + Sudoku[7][4] + Sudoku[7][5] + Sudoku[8][3] + Sudoku[8][4] + Sudoku[8][5]) == 45) {

            correta = true;

        }
        //Nono Quadrado
        if ((Sudoku[6][6] + Sudoku[6][7] + Sudoku[6][8] + Sudoku[7][6] + Sudoku[7][7] + Sudoku[7][8] + Sudoku[8][6] + Sudoku[8][7] + Sudoku[8][8]) != 45) {

            correta = false;

        } else if ((Sudoku[6][6] + Sudoku[6][7] + Sudoku[6][8] + Sudoku[7][6] + Sudoku[7][7] + Sudoku[7][8] + Sudoku[8][6] + Sudoku[8][7] + Sudoku[8][8]) == 45) {

            correta = true;

        }

return correta;
    }
}
