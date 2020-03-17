package model;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MaxSupLegion {

    private final String AT = "AngelsApp 1.0";
    private final String[] MONTHS = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto",
            "Septiembre", "Octubre", "Noviembre", "Diciembre" };

    private final String[] SIZECANDLE = { "Pequnio", "Mediano", "Grande" };

    private ArrayList<Angel> angels;

    public MaxSupLegion() {
        angels = new ArrayList<Angel>();
    }

    public ArrayList<Angel> getAngels() {
        return angels;
    }

    public void setAngels(ArrayList<Angel> angels) {
        this.angels = angels;
    }

    public void addAngels() {
        String name, type, photo, prayer, cMonth, cDay, power, color, essence, size;
        double lighting;
        boolean aux = false;
        int opt;

        do {

            do {
                name = JOptionPane.showInputDialog(null,
                        "Nombre (Recuerde que el nombre de los Arcangeles empieza por mayuscula y termina en 'el'.):\n",
                        AT, 3);
                if (name.charAt(name.length() - 1) == 'l' && name.charAt(name.length() - 2) == 'e') {
                    aux = true;
                } else {
                    JOptionPane.showMessageDialog(null, "El nombre no termina en 'el'.\n   Intente nuevamente\n", AT,
                            0);
                }
            } while (aux == false);
            type = "Arcangel";
            photo = JOptionPane.showInputDialog(null, "Link de la fo to:\n", AT, 3);
            prayer = JOptionPane.showInputDialog(null, "Ingrese la oracion:\n", AT, 3);
            cMonth = String.valueOf(
                    JOptionPane.showInputDialog(null, "Mes de celebracion:\n", AT, 3, null, MONTHS, MONTHS[0]));
            cDay = JOptionPane.showInputDialog(null, "Dia de celebracion (dd):\n", AT, 3);
            power = JOptionPane.showInputDialog(null, "Poder (Todo en minusculas):\n", AT, 3);
            color = JOptionPane.showInputDialog(null, "Color de la vela:\n", AT, 3);
            size = String.valueOf(
                    JOptionPane.showInputDialog(null, "Tamanio de la vela:\n", AT, 3, null, SIZECANDLE, SIZECANDLE[0]));
            essence = JOptionPane.showInputDialog(null, "Esencia de la vela:\n", AT, 3);
            lighting = Double.parseDouble(JOptionPane.showInputDialog(null, "Candela (0 a 1000):\n", AT, 3));

            angels.add(new Angel(name, type, photo, prayer, cMonth, cDay, power,
                    new Candle(color, essence, lighting, size)));
            JOptionPane.showMessageDialog(null, "Registrado con exito ", AT, 1);

            opt = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "\n   1. Agregar un nuevo arcangel.\n   2. volver al menu principal.\n", AT, 2));
        } while (opt == 1);

    }

    public void countArchangels() {
        JOptionPane.showMessageDialog(null, "   Hay " + angels.size() + " Arcangeles registrados", AT, 1);
    }

    public int searchByName(String name) {
        int index = -1;
        for (int i = 0; i < angels.size(); i++) {
            if (angels.get(i).getName().equals(name) == true) {
                index = i;
            }
        }
        return index;
    }

    public void showAngelByName() {
        String name = JOptionPane.showInputDialog(null, "Nombre (No olvide que la primera letra va en mayuscula): \n",
                AT, 3);
        if (searchByName(name) == -1) {
            JOptionPane.showMessageDialog(null, "Angel no encontrado", AT, 0);
        } else {
            JOptionPane.showMessageDialog(null, angels.get(searchByName(name)).toString(), AT, 1);
        }

    }

    public int searchByPower(String power) {
        int index = -1;
        for (int i = 0; i < angels.size(); i++) {
            if (angels.get(i).getPower().equals(power) == true) {
                index = i;
            }
        }
        return index;
    }

    public void showAngelByPower() {
        String power = JOptionPane.showInputDialog(null, "Poder (No olvide que empieza por minuscula): \n", AT, 3);
        if (searchByName(power) == -1) {
            JOptionPane.showMessageDialog(null, "Angel no encontrado", AT, 0);
        } else {
            JOptionPane.showMessageDialog(null, angels.get(searchByName(power)).toString(), AT, 1);
        }

    }

    public int[] searchAllByMonth(String cMonth) {
        ArrayList<Integer> index = new ArrayList<Integer>();

        for (int i = 0; i < angels.size(); i++) {
            if (angels.get(i).getcMonth().equals(cMonth) == true) {
                index.add(i);

            }
        }
        int[] in = new int[index.size()];
        for (int j = 0; j < in.length; j++) {
            in[j] = Integer.parseInt(String.valueOf(index.get(j)));
        }

        return in;
    }

    public void showAllByMonth() {
        String cMonth;
        cMonth = String
                .valueOf(JOptionPane.showInputDialog(null, "Mes de celebracion:\n", AT, 3, null, MONTHS, MONTHS[0]));

        cMonth.toUpperCase();
        String allByMonth = cMonth + ": \n\n";
        int[] index = searchAllByMonth(cMonth);

        for (int i = 0; i < index.length; i++) {
            allByMonth += angels.get(index[i]).byMonth();
        }

        if (allByMonth.equals(cMonth + ": \n\n") == true) {
            JOptionPane.showMessageDialog(null, "No hay registros para este mes.", AT, 0);
        } else {
            JOptionPane.showMessageDialog(null, allByMonth, AT, 1);
        }

    }

    public void superFinalString() {
        String superString = "Todos los registros: \n";
        for (int i = 0; i < angels.size(); i++) {
            superString += angels.get(i).toFinalString();
        }

        if (superString.equals("Todos los registros: \n") == true) {
            JOptionPane.showMessageDialog(null, "No hay registros.", AT, 0);
        } else {
            JOptionPane.showMessageDialog(null, superString, AT, 1);
        }
    }

}