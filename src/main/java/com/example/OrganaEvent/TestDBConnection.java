package com.example.OrganaEvent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class TestDBConnection implements CommandLineRunner {

    private final DataSource dataSource;

    public TestDBConnection(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run(String... args) throws Exception {
        try (Connection conn = dataSource.getConnection()) {
            System.out.println("✅ Connexion à la base OK : " + conn.getMetaData().getURL());
        }
    }
}

