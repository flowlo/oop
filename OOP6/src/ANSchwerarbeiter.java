public abstract class ANSchwerarbeiter extends ANAndroide {
	public ANSchwerarbeiter(SKSensitiveSkin skin, SWSchwerarbeiterSoftware software)
	{
		this.skin = skin;
		this.software = software;
	}

	public ANSchwerarbeiter(SKHochfesterSkin skin, SWSchwerarbeiterSoftware software)
	{
		this.skin = skin;
	}
}
