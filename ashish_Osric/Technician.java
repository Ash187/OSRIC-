
/**
 * Summary description for Technician.
 */
public class Technician
{

	private int technicianNumber;
	private String technicianName;
	private int shift;
   private String technicianComplain;


	public Technician()
	{
	}

	// Function: default assignments for technician attributes
	// Input: technician attributes
	// Output: None
	public Technician(String id, String name, String shift, String complain)
	{
		technicianNumber = Integer.parseInt(id);
		technicianName = name;
		this.shift = Integer.parseInt(shift);
      technicianComplain=complain;
	}

	//Function: set information for given buffer string of technician information
	// Input: String buffer of technician information
	// Output: None
	public Technician(String bufferinfo)
	{
		this.setInformation(bufferinfo);
	}


//******************************************** Set Functions ********************************************
	void setTechnicianName(String newName)
	{
		technicianName = newName;
	}
   void setTechnicianComplain(String newComplain)
	{
		technicianComplain = newComplain;
	}


	void setTechnicianNumber(int newTechnicianNumber)
	{	
		technicianNumber = newTechnicianNumber;
	}

	void setShift(int newShift)
	{
		shift = newShift;
	}

	void setInformation(String buffer)
	{
		String buffersplit[] = buffer.split("#");
		technicianNumber = Integer.parseInt(buffersplit[0]);
		technicianName = buffersplit[1];
		shift = buffersplit[2].charAt(0);
	}

//******************************************* Get Functions ***********************************************

	int getTechnicianNumber()
	{
		return technicianNumber;
	}

	String getTechnicianName()
	{
		return technicianName;
	}
   
   String getTechnicianComplain()
	{
		return technicianComplain;
	}

   
	int getTechnicianShift()
	{
		return shift;
	}


	
//****************************************** Process Functions **********************************************
	
	// Function: Find Technician given technician number & set technician information
	// Input: int techncian number
	// Output: true\false if technician is found
	boolean findTechnician(int technicianNumber)
	{
		Technician_File tFile = new Technician_File();
		String buffer;
		try 
		{
			buffer = tFile.getTechnician(technicianNumber);
			setInformation(buffer);
			return true;
		} 
		catch (Exception e)
		{
			return false;
		}

	}

	// Function: Find techician given assistant input of customer number & set technician information
	// Input: None
	// Output: true\false if technician is foudn
	boolean findTechnician()
	{
		Technician_File tFile = new Technician_File();
		String buffer;

		try 
		{
			System.out.print("Please enter technician's number: ");
			technicianNumber = Get_Input.readNumber(9999999);

			buffer = tFile.getTechnician(technicianNumber);
			setInformation(buffer);
			return true;
		} 
		catch (Exception e)
		{
			System.out.println("Technician number " + technicianNumber + " not found.");
			System.out.println("Returning to main menu.");
			return false;
		}
	}

	
	// Function: Add Technician Information Control Class - get new tech name & Shift, get new tech number, 
	//	and confirm & display new tech number to screen
	// Input: None
	// Output: None
	void getAddInformation()
	{
		Technician_File tFile = new Technician_File();
		
		System.out.print("Please enter technician name: ");
		technicianName = Get_Input.readString(100);
		
		System.out.print("Please enter technician's shift (1=day, 2=night1, 3=night2): ");
		shift = Get_Input.readSelection(3);
		
		technicianNumber = tFile.getNewNumber();

		tFile.addTechnician(technicianNumber + "#" + 
			technicianName + "#" +
			(shift-1));

	}
   
   //Function: complain about technician
   void getComplainInformation()
	{
		Technician_File tFile = new Technician_File();
		
		System.out.print("Please enter technician name: ");
		technicianName = Get_Input.readString(100);
		
		
		technicianNumber = tFile.getNewNumber();
      
      System.out.print("Please enter your complain: ");
		technicianComplain = Get_Input.readString(1000);


		tFile.complainTechnician(technicianName + "#" + 
			technicianComplain);

	}



	// Function: update technician shift give assitant provided input and save update to file
	// Input: None
	// Output: none
	void getUpdateInformation()
	{
		Technician_File tFile = new Technician_File();

		System.out.print("Please enter technician's shift (1=day, 2=night1, 3=night2): ");
		this.shift = Get_Input.readSelection(3);
		
		tFile.updateTechnician(this.getTechnicianNumber() + "#" + 
			this.getTechnicianName() + "#" +
			this.getTechnicianShift());

	}


	// Function: delete technician given set technician number already
	// Input: None
	// Output: None
	void deleteTechnician()
	{
		Technician_File tFile = new Technician_File();
		tFile.deleteTechnician(this.technicianNumber);
	}


	// Function: get technician by given shift
	// Input: Int Shift
	// Output: None
	String getTechniciansByShift(int shift)
	{
		Technician_File tFile = new Technician_File();
		return tFile.getTechniciansByShift(shift);
	}
}
