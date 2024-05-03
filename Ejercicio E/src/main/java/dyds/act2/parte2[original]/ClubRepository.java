package dyds.act2.parte2;

public class ClubRepository {
	
	public static final int T = 10; // max time to keep a local record before refreshing form remote, in days
	
	private final ClubLocalSource clubLocalSource;
	private final ClubRemoteSource clubRemoteSource;
	
	public ClubRepository(ClubLocalSource clubLocalSource, ClubRemoteSource clubRemoteSource) {
		super();
		this.clubLocalSource = clubLocalSource;
		this.clubRemoteSource = clubRemoteSource;
	}

	public ClubLocalSource getFilmLocalSource() {
		return clubLocalSource;
	}

	public ClubRemoteSource getFilmRemoteSource() {
		return clubRemoteSource;
	}
}
