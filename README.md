# Argon2id Passwort-Derivator
Ein sicherer, vollständig offline arbeitender Passwort-Generator auf Basis von **Argon2id**.

<img width="301" height="893" alt="Bildschirmfoto 2025-11-26 um 00 46 21" src="https://github.com/user-attachments/assets/42d7dcee-38b0-4f39-be52-865d8fea209b" />
<img width="299" height="899" alt="Bildschirmfoto 2025-11-26 um 00 46 48" src="https://github.com/user-attachments/assets/416570bb-8f81-4e46-b68a-351318319ea6" />

Die App erzeugt aus einem einzigen **Master-Passwort** und einem **Dienst-/Plattformnamen** (z. B. „amazon“, „ebay“, „google“) ein starkes, eindeutiges Passwort – ohne Speicherung, ohne Internet, vollständig lokal.

---

## Funktionen

### Sichere Passwort-Ableitung  
Aus folgenden Eingaben:
- **Master-Passwort**
- **Dienstname / Domain / Schlüsselwort**

wird ein starkes, deterministisches Passwort erzeugt.  
Das Ergebnis ist:
- für jeden Dienst einzigartig  
- jederzeit wieder reproduzierbar  
- ohne Speicherung nutzbar  

### Moderne Kryptografie (Argon2id KDF)
Die App nutzt **Argon2id**, Gewinner des *Password Hashing Competition*, mit sicheren Standardparametern:

- **Typ:** Argon2id  
- **Iterationen:** 5  
- **Memory:** 128 MB  
- **Parallelität:** 2  
- **Hash-Länge:** 32 Bytes  
- **Ausgabe:** Base64  

Diese Parameter machen Brute-Force-Angriffe extrem kostspielig.

### Keine Daten werden gespeichert  
Die App speichert **keinerlei Informationen**:
- keine Passwörter  
- keine Ableitungen  
- keine Logs  
- keine Dateien  
- keine Netzwerkanfragen  

Alles wird ausschließlich im RAM berechnet.

### Kopieren in die Zwischenablage  
Ein Klick erzeugt ein Passwort und kopiert es direkt in die System-Zwischenablage.

### Info-Dialog mit Hinweisen  
Ein Info-Icon oben rechts öffnet Hinweise zur sicheren Nutzung.

### Offline und Open Source  
Die App funktioniert zu 100 % offline und enthält keinen Tracking- oder Cloud-Code.

---

## Warum diese App?

Viele Nutzer verwenden:
- schwache Passwörter,
- oder wiederholen Passwörter über viele Dienste hinweg.

Passwortmanager speichern Datenbanken oder synchronisieren online.  
Diese App funktioniert anders:

**Ein Master-Passwort ⇒ unendlich viele starke Passwörter.  
Kein Speichern, keine Cloud, keine Datenbank.**

Ein Konzept ähnlich zu *Password Derivation Tools*, jedoch mit:
- modernen KDF-Parametern,  
- intuitiver UI,  
- zero-storage-Design.  

---

## Sicherheitshinweise

- Wähle ein starkes, gut merkbares Master-Passwort.
- Das generierte Dienst-Passwort hängt vom eingegebenen Dienstnamen ab.
- Das abgeleitete Passwort ist für jeden Dienst einzigartig.
- Kopierte Passwörter liegen nur in der Zwischenablage deines Systems.

---

## Plattformen
- **Android** (aktuell)  
