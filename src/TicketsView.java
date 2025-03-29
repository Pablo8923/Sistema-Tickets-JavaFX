import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TicketsView {
    private Stage stage;
    // Ruta completa del archivo tickets.txt
    private static final String FILE_NAME = "C:\\Users\\Pablo G. Mux\\OneDrive\\Documentos\\NetBeansProjects\\JavaApplication4\\src\\tickets.txt";

    public TicketsView(Stage stage) {
        this.stage = stage;
    }

    public VBox getView() {
        VBox layout = new VBox(10);
        Label titleLabel = new Label("Lista de Tickets");
        ListView<String> ticketList = new ListView<>();
        Button addTicketButton = new Button("Agregar Ticket");

        // Cargar tickets desde el archivo
        List<String> tickets = loadTicketsFromFile();
        ticketList.getItems().addAll(tickets);

        // Acción para agregar un nuevo ticket
        addTicketButton.setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Nuevo Ticket");
            dialog.setHeaderText("Agregar un nuevo ticket");
            dialog.setContentText("Descripción del ticket:");

            dialog.showAndWait().ifPresent(ticket -> {
                ticketList.getItems().add(ticket);
                saveTicketToFile(ticket); // Guardar el ticket en el archivo
            });
        });

        layout.getChildren().addAll(titleLabel, ticketList, addTicketButton);
        return layout;
    }

    // Método para cargar tickets desde el archivo
    private List<String> loadTicketsFromFile() {
        List<String> tickets = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                tickets.add(line);
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar el archivo de tickets: " + e.getMessage());
        }
        return tickets;
    }

    // Método para guardar un ticket en el archivo
    private void saveTicketToFile(String ticket) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(ticket);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("No se pudo guardar el ticket: " + e.getMessage());
        }
    }
}