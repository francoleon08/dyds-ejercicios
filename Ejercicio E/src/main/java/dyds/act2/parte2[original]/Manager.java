package dyds.act2.parte2;

public class Manager {

	private final ClubRepository repo;
	
	public Manager(ClubRepository repo) {
		super();
		this.repo = repo;
	}

	public Club get(int id) {
		
		Club a =  repo.getFilmLocalSource().getClub(id);
		
		// If it's not locally saved or too old, fetch it from remote and save it locally
		if(a == null || System.currentTimeMillis() - a.getTimeStamp() > ClubRepository.T * 24 * 60 * 1000) {
			//Replace these lines with calls to parte1 module, when they decide to finish it
			a = repo.getFilmRemoteSource().get(id);
			repo.getFilmLocalSource().storeClub(a);
		}
		
		return a;
	}
}
