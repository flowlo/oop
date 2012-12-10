/**
 * Zusicherungern: * Der Name des Bauernhofs ist eindeutig und unveraenderlich
 */
@Authors("Dominik")
public class Bauernhof {
	private final String name;
	private TraktorenListe traktoren = new TraktorenListe();

	@Authors("Dominik")
	public Bauernhof(String name) {
		this.name = name;
	}

	@Authors("Dominik")
	public String getName() {
		return name;
	}

	@Authors("Dominik")
	public void addTraktor(Traktor traktor) {
		traktoren.add(traktor);
	}

	@Authors("Dominik")
	public void removeTraktor(Traktor traktor) {
		traktoren.remove(traktor);
	}

	@Authors("Simon")
	public void removeTraktor(int nummer) {
		traktoren.remove(nummer);
	}

	@Authors("Simon")
	public boolean containsTraktor(int nummer) {
		return traktoren.contains(nummer);
	}

	@Authors("Dominik")
	public void erhoeheDieselVerbrauch(int nummer, Integer diesel) {
		Traktor traktor = traktoren.get(nummer);
		if (traktor != null && traktor instanceof DieselTraktor) {
			((DieselTraktor) traktor).erhoeheVerbrauch(diesel);
		}
	}

	@Authors("Dominik")
	public void erhoeheBiogasVerbrauch(int nummer, Float biogas) {
		Traktor traktor = traktoren.get(nummer);
		if (traktor != null && traktor instanceof BiogasTraktor) {
			((BiogasTraktor) traktor).erhoeheVerbrauch(biogas);
		}
	}

	@Authors("Dominik")
	public void setEinsatzzweck(int nummer, Einsatzzweck einsatzzweck) {
		Traktor traktor = traktoren.get(nummer);
		if (traktor != null) {
			traktor.setEinsatzzweck(einsatzzweck);
		}
	}

	@Authors("Dominik")
	public double getDurchschnittBetriebsstunden(
			EinsatzzweckGruppierung gruppierung) {
		return getStatistik(gruppierung, TraktorGruppierung.GESAMT,
				StatistikTyp.DURCHSCHNITT_BETRIEBSSTUNDEN).doubleValue();
	}

	@Authors("Dominik")
	public double getDurchschnittBetriebsstunden(TraktorGruppierung gruppierung) {
		return getStatistik(EinsatzzweckGruppierung.GESAMT, gruppierung,
				StatistikTyp.DURCHSCHNITT_BETRIEBSSTUNDEN).doubleValue();
	}

	@Authors("Dominik")
	public double getDurchschnittDieselverbrauch(
			EinsatzzweckGruppierung gruppierung) {
		return getStatistik(gruppierung, TraktorGruppierung.DIESEL,
				StatistikTyp.DURCHSCHNITT_VERBRAUCH).doubleValue();
	}

	@Authors("Dominik")
	public double getDurchschnittBiogasverbrauch(
			EinsatzzweckGruppierung gruppierung) {
		return getStatistik(gruppierung, TraktorGruppierung.BIOGAS,
				StatistikTyp.DURCHSCHNITT_VERBRAUCH).doubleValue();
	}

	@Authors("Dominik")
	public int getMinimumSaescharen(TraktorGruppierung gruppierung) {
		return getStatistik(EinsatzzweckGruppierung.SAEEN, gruppierung,
				StatistikTyp.MINIMUM_SAESCHARE).intValue();
	}

	@Authors("Dominik")
	public int getMaximumSaescharen(TraktorGruppierung gruppierung) {
		return getStatistik(EinsatzzweckGruppierung.SAEEN, gruppierung,
				StatistikTyp.MAXIMUM_SAESCHARE).intValue();
	}

	@Authors("Dominik")
	public double getDurchschnittFassungskapazitaet(
			TraktorGruppierung gruppierung) {
		return getStatistik(EinsatzzweckGruppierung.SAEEN, gruppierung,
				StatistikTyp.DURCHSCHNITT_FASSUNGSKAPAZITAET).doubleValue();
	}

	@Authors("Dominik")
	private Number getStatistik(
			EinsatzzweckGruppierung einsatzzweckGruppierung,
			TraktorGruppierung traktorGruppierung, StatistikTyp statistik) {
		boolean saeen = einsatzzweckGruppierung == EinsatzzweckGruppierung.GESAMT
				|| einsatzzweckGruppierung == EinsatzzweckGruppierung.SAEEN;
		boolean duengen = einsatzzweckGruppierung == EinsatzzweckGruppierung.GESAMT
				|| einsatzzweckGruppierung == EinsatzzweckGruppierung.DUENGEN;
		boolean diesel = traktorGruppierung == TraktorGruppierung.GESAMT
				|| traktorGruppierung == TraktorGruppierung.DIESEL;
		boolean biogas = traktorGruppierung == TraktorGruppierung.GESAMT
				|| traktorGruppierung == TraktorGruppierung.BIOGAS;
		Number value = 0;
		int anzahl = 0;

		Bauernhof.TraktorenListe.TraktorEintrag current = traktoren.getHead();
		do {
			Traktor traktor = current.getTraktor();
			if (((traktor.tutDuengen() && duengen) || (traktor.tutSaeen() && saeen))
					&& ((traktor instanceof DieselTraktor && diesel) || (traktor instanceof BiogasTraktor && biogas))) {
				anzahl += 1;
				if (statistik == StatistikTyp.DURCHSCHNITT_VERBRAUCH) {
					if (traktor instanceof DieselTraktor) {
						value = value.intValue()
								+ ((DieselTraktor) traktor)
										.getBisherigerVerbrauch();
					} else if (traktor instanceof BiogasTraktor) {
						value = value.doubleValue()
								+ ((BiogasTraktor) traktor)
										.getBisherigerVerbrauch();
					}
				} else if (statistik == StatistikTyp.DURCHSCHNITT_BETRIEBSSTUNDEN) {
					value = value.intValue() + traktor.getBetriebsstunden();
				} else if (statistik == StatistikTyp.DURCHSCHNITT_FASSUNGSKAPAZITAET
						&& traktor.tutDuengen()) {
					value = value.doubleValue()
							+ traktor.getFassungskapazitaet();
				} else if (statistik == StatistikTyp.MINIMUM_SAESCHARE
						&& traktor.tutSaeen()) {
					value = Math.min(value.intValue(),
							traktor.getAnzahlSaeschare());
				} else if (statistik == StatistikTyp.MAXIMUM_SAESCHARE
						&& traktor.tutSaeen()) {
					value = Math.max(value.intValue(),
							traktor.getAnzahlSaeschare());
				}
			}
		} while ((current = current.getNext()) != null);

		if (statistik == StatistikTyp.MINIMUM_SAESCHARE
				|| statistik == StatistikTyp.MAXIMUM_SAESCHARE) {
			return value;
		} else if (statistik == StatistikTyp.DURCHSCHNITT_BETRIEBSSTUNDEN
				|| statistik == StatistikTyp.DURCHSCHNITT_FASSUNGSKAPAZITAET
				|| statistik == StatistikTyp.DURCHSCHNITT_VERBRAUCH) {
			return value.doubleValue() / anzahl;
		} else {
			return Double.NaN;
		}
	}

	/**
	 * Hier wurde das Interface Iterable nicht implementiert, da Generizitaet
	 * laut Angabe verboten ist.
	 * 
	 * Zusicherungen: * Jeder Traktor darf nur einmal in der Liste vorkommen
	 * (Nummer ist eindeutig)
	 */
	@Authors("Dominik")
	public class TraktorenListe {
		TraktorEintrag head = null;

		@Authors("Dominik")
		protected Traktor get(int nummer) {
			TraktorEintrag current = head;
			do {
				if (current.getTraktor().getNummer() == nummer) {
					return current.getTraktor();
				}
			} while ((current = current.getNext()) != null);
			return null;
		}

		@Authors("Dominik")
		protected void add(Traktor traktor) {
			if (head != null) {
				if (!contains(traktor)) {
					TraktorEintrag newHead = new TraktorEintrag(traktor);
					newHead.add(head);
					head = newHead;
				}
			} else {
				head = new TraktorEintrag(traktor);
			}
		}

		@Authors("Dominik")
		protected void remove(Traktor traktor) {
			if (head.getTraktor().getNummer() != traktor.getNummer()) {
				TraktorEintrag current = head;
				TraktorEintrag last = null;
				while ((current = current.getNext()) != null) {
					if (current.getTraktor().getNummer() == traktor.getNummer()) {
						last.setNext(current.getNext());
						return;
					}
					last = current;
				}
			} else {
				head = head.getNext();
			}
		}

		@Authors("Simon")
		protected void remove(int nummer) {
			if (head.getTraktor().getNummer() != nummer) {
				TraktorEintrag current = head;
				TraktorEintrag last = null;
				while ((current = current.getNext()) != null) {
					if (current.getTraktor().getNummer() == nummer) {
						last.setNext(current.getNext());
						return;
					}
					last = current;
				}
			} else {
				head = head.getNext();
			}
		}

		@Authors("Simon")
		protected boolean contains(int nummer) {
			if (head != null) {
				TraktorEintrag current = head;
				do {
					if (current.getTraktor().getNummer() == nummer) {
						return true;
					}
				} while ((current = current.getNext()) != null);
				return false;
			} else {
				return false;
			}
		}

		@Authors("Dominik")
		private boolean contains(Traktor traktor) {
			if (head != null) {
				TraktorEintrag current = head;
				do {
					if (current.getTraktor().getNummer() == traktor.getNummer()) {
						return true;
					}
				} while ((current = current.getNext()) != null);
				return false;
			} else {
				return false;
			}
		}

		@Authors("Dominik")
		protected TraktorEintrag getHead() {
			return head;
		}

		@Authors("Dominik")
		public class TraktorEintrag {
			private Traktor traktor;
			private TraktorEintrag next = null;

			@Authors("Dominik")
			protected TraktorEintrag(Traktor traktor) {
				this.traktor = traktor;
			}

			@Authors("Dominik")
			protected Traktor getTraktor() {
				return traktor;
			}

			@Authors("Dominik")
			protected TraktorEintrag getNext() {
				return next;
			}

			@Authors("Dominik")
			protected void add(TraktorEintrag traktorEintrag) {
				if (next == null) {
					next = traktorEintrag;
				} else {
					next.add(traktorEintrag);
				}
			}

			@Authors("Dominik")
			protected void setNext(TraktorEintrag traktorEintrag) {
				next = traktorEintrag;
			}
		}
	}
}
