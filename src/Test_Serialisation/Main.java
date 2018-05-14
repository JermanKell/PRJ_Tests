package Test_Serialisation;

public class Main {

	public static void main(String[] args) {
		Serialization ser = new Serialization();
		Deserialization des = new Deserialization();
		
		// Le code copié fonctionne parfaitement
		//	=> recherche de l'erreur en cours
		ser.writeData("Comment vas-tu ? Je suis content de te voir !");
		des.toDeserialize();
	}

}
