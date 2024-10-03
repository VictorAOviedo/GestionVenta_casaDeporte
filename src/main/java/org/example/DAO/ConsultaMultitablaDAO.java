package org.example.DAO;

import java.sql.SQLException;
import java.util.List;

public interface ConsultaMultitablaDAO {
     List<String> generarConsultaMultitablas(String tabla1, String tabla2) throws SQLException;
}
