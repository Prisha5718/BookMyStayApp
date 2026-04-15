import java.io.*;

public class PersistenceService {

    private static final String FILE_NAME =
            "system_state.dat";

    public void saveState(
            SystemState state
    ) {

        try (ObjectOutputStream out =
                     new ObjectOutputStream(
                             new FileOutputStream(
                                     FILE_NAME
                             )
                     )) {

            out.writeObject(state);

            System.out.println(
                    "System state saved successfully."
            );

        } catch (IOException e) {

            System.out.println(
                    "Error while saving data."
            );
        }
    }

    public SystemState loadState() {

        try (ObjectInputStream in =
                     new ObjectInputStream(
                             new FileInputStream(
                                     FILE_NAME
                             )
                     )) {

            return (SystemState)
                    in.readObject();

        } catch (IOException
                 | ClassNotFoundException e) {

            System.out.println(
                    "Recovery failed. Starting fresh."
            );

            return null;
        }
    }
}