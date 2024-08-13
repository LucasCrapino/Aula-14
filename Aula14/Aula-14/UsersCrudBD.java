import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;

public class UsersCrudBD {
    public void searchNamesAndPasswords(String user, String password) {
        String sqlSelect = "SELECT NAMES FROM VALID_USERS WHERE NAMES = ? AND PASSWORDS = ?";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;
        ResultSet rs;

        try {
            stmt = conn.prepareStatement(sqlSelect);
            stmt.setString(1, user);
            stmt.setString(2, password);
            rs = stmt.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!");

                
                ArrayList<Student> studentData = getAllGrades();

                
                Tables tables = new Tables(studentData);
            } else {
                JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválidos!");
            }
        } catch (SQLException ex) {
            System.out.println("Usuário ou senha inválidos: " + ex.toString());
        } finally {
            ConnFactory.closeConn(conn, stmt);
        }
    }

    public ArrayList<Student> getAllGrades() {
        ArrayList<Student> aL = new ArrayList<>();
        String sqlSelect = "SELECT DISCIPLINA, P1, P2, FALTAS FROM STUDENT_INFO";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;
        ResultSet rs;

        try {
            stmt = conn.prepareStatement(sqlSelect);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Student uD = new Student();
                uD.setDiscipline(rs.getString("DISCIPLINA"));
                uD.setGradeOne(rs.getDouble("P1"));
                uD.setGradeTwo(rs.getDouble("P2"));
                uD.setAbsents(rs.getInt("FALTAS"));
                aL.add(uD);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar todos os dados: " + ex.toString());
        } finally {
            ConnFactory.closeConn(conn, stmt);
        }
        return aL;
    }
}