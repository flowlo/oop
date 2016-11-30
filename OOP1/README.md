### Welche Aufgabe zu lösen ist:

Schreiben Sie in Java den Kern eines Programms zur Verwaltung der Proben und Auftritte einer Musikgruppe (Name und Ausrichtung frei wählbar). Aus Sicht eines Anwenders sollen folgende Vorgänge unterstützt werden:

 * Anlegen einer neuen Probe bzw. eines neuen Auftritts mit allen notwendigen Daten wie Ort, Datum, Uhrzeit, Dauer, Raummiete für eine Probe, Gage für einen Auftritt.
 * Auflistung aller Proben/Auftritte mit allen Daten innerhalb eines gegebenen Zeitraums (von Datum bis Datum), wobei nur Proben, nur Auftritte oder alles zusammen aufgelistet werden kann.
 * Summe der Kosten bzw. des Gewinns aus Mieten bzw. Gagen innerhalb eines gegebenen Zeitraums, wieder getrennt nach Proben und Auftritten sowie alles zusammen.
 * Hinzufügen, Entfernen und Auflisten der aktuellen Mitglieder der Musikgruppe mit Daten wie Name, Telefonnummer, Instrument.
Auflisten der Mitglieder zu einem gegebenen früheren Zeitpunkt.
 * Hinzufügen, Entfernen und Auflisten der aktuellen Musikstücke im Repertoire (deren Namen und Längen).
 * Auflisten des Repertoires zu einem gegebenen früheren Zeitpunkt.

Schreiben Sie nur den Kern eines entsprechenden Programms (ohne Benutzerschnittstelle) sowie ein Testprogramm. Der Kern soll die oben beschriebene Funktionalität aufweisen, aber keinerlei Eingabe von der Tastatur oder Ausgabe auf den Bildschirm (und auch nicht von/auf eine Datei) machen. Daher müssen alle benötigten bzw. erzeugten Daten über Parameter und Rückgabewerte von Methoden übergeben werden. Entsprechende Typen der Daten müssen Sie selbst finden. Einige Methoden benötigen für ihre Durchführung das aktuelle Datum, das ebenfalls über Parameter übergeben werden soll. Die Daten im System können bei Programmbeendigung verloren gehen und brauchen nicht in einer Datei gespeichert zu werden.

Das Testprogramm soll mittels `java Test` von Gruppe/Aufgabe1 aus aufrufbar sein und die oben beschriebene Funktionalität überprüfen. Die Tests sollen selbständig ohne Benutzerinteraktion ablaufen, sodass Aufrufer keine Testfälle auswählen oder Testdaten eintippen müssen. Alle Testdaten sollen im Testprogramm vorgegeben sein. Testergebnisse sollen aber (in nachvollziehbarer und verständlicher Form) am Bildschirm ausgegeben werden.

### Wie die Aufgabe zu lösen ist:

Der Programmcode Ihrer Lösung soll möglichst einfach sein und keine unnötige Funktionalität haben. Der Code soll auch wiederverwendbar sein, da die nächste Aufgabe voraussichtlich auf Teilen davon aufbaut. Vermeiden Sie jedoch Vorgriffe, das heißt, schreiben Sie *keine Programmteile* aufgrund der Vermutung, dass diese Teile in der nächsten Aufgabe verlangt sein könnten.
Achten Sie bei der Lösung der Aufgabe besonders auf Datenabstraktion: Alles, was kaum trennbar miteinander verbunden ist, soll in einem Objekt gekapselt sein, leicht voneinander trennbare Einheiten sollen zu verschiedenen Objekten gehören. Es soll in Ihrem Programm mehrere, voneinander möglichst unabhängige Objekte geben. Auf Daten soll nur über dafür vorgesehene Methoden zugegriffen werden. Unnötige Zugriffe und unnötige Zugreifbarkeit von Daten und Methoden sind zu vermeiden. Achten Sie auf hohen Klassenzusammenhalt und schwache Objektkopplung.

Diese Aufgabe hilft auch den Tutor(inn)en bei der Einschätzung Ihrer Kenntnisse sowie der Zusammenarbeit in der Gruppe. Bitte sorgen Sie in Ihrem eigenen Interesse dafür, dass Sie diese Aufgabe in der Gruppe lösen (ohne Abschreiben) und jedes Gruppenmitglied etwa in gleichem Maße mitarbeitet. Sonst könnten Sie bei einer Fehleinstufung wertvolle Zeit verlieren. Scheuen Sie sich bitte nicht, Ihre(n) Tutor(in) um Hilfe zu bitten, falls Sie bei der Lösung der Aufgabe Probleme haben oder keine brauchbare Zusammenarbeit in der Gruppe zustandekommt.

### Warum die Aufgabe diese Form hat:

Die Aufgabe kommt aus einem Anwendungsbereich, den Sie kennen oder zumindest abschätzen können. Der Umfang ist so gewählt, dass die Programmierung bei guter Organisation nicht zu viel Zeit in Anspruch nehmen sollte. Nutzen Sie die Gelegenheit, um die Aufgabenteilung und internen Abläfe innerhalb der Gruppe zu organisieren. Auf eine genaue Spezifikation der Aufgabenstellung wird aus folgenden Gründen bewusst verzichtet:

 * Sie sollen in der Gruppe diskutieren, wie Sie die Aufgabe verstehen und welche Lösungswege geeignet erscheinen.
 * Sie sollen sich von Anfang an daran gewöhnen, dass Aufgaben in der Regel nicht vollständig spezifiziert sind, aber trotzdem bestimmte Vorgaben eingehalten werden müssen.
 * Sie sollen sich eine eigene brauchbare Faktorisierung überlegen und dabei von Merkmalen wie Datenkapselung, Klassenzusammenhalt und Objektkopplung (statt starrer Vorgaben) leiten lassen.
 * Sie sollen auch die Verantwortung für die Korrektheit Ihrer Lösung (so wie Sie sie selbst verstehen) übernehmen, indem Sie entsprechende Tests durchführen.
