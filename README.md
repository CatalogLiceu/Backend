Pasi pt. rulare a aplicatiei:

Versiune JDK:
![image](https://github.com/user-attachments/assets/4b31ac4d-2148-4e24-9c3a-d5c7fb2da07b)

Baza de date:
1. Instalare PostgreSQL.
2. Creare o baza de date numita 'CatalogLiceu' (din pgAdmin).
3. In IntelliJ:
    ![image](https://github.com/user-attachments/assets/78d33704-8e37-4bb8-a227-ee22127a1386)
4. Configurare campuri necesare:
   ![image](https://github.com/user-attachments/assets/efe9ccb5-efdf-407f-a1c0-9a993908c6da)
   ![image](https://github.com/user-attachments/assets/22973b5b-9f66-4a73-8905-71b7f8ca470a)
5. In 'application.properties' (asigurati-va ca sunt folosite aceleasi credentiale ca in PgAdmin si pasul anterior):
   ![image](https://github.com/user-attachments/assets/0b94b374-9161-4ed0-8a3f-5d338f671564)
  

Link Swagger (se poate accesa dupa ce se porneste server-ul): http://localhost:8080/swagger-ui/index.html
Sa se verifice ce port foloseste aplicatia! (default: 8080)

Aplicatia porneste cu un cont de admin, ce are roluri de 'administrator platforma'. Porecla si parola pt. acest user sunt ambele 'admin'. Se copie JWT-ul generat dupa logare:
![image](https://github.com/user-attachments/assets/1dab4891-1019-4823-913e-ae25b447d22b)

Se apasa pe 'Authorize' si se da paste la JWT-ul generat:
![image](https://github.com/user-attachments/assets/0cffc31e-7794-42cf-8361-04fff256e9eb)

Rolul default de administrator platforma poate face anumite lucruri precum adaugare profile / specializari / licee / ani clase / materii / etc. si adaugare permisii de administrator scolar pt. anumite licee. Pt. adaugare profesorilor / elevilor / claselor intr-un liceu, este nevoie de un cont de administrator scolar pe care doar administratorul platformei il poate crea. Administratorul platformei nu are mai multe permisii de a schimba datele legate de un liceu / elevi / profesori, etc.
Roluri:
Administator platforma -> se ocupa de adaugarea materiilor, liceelor, specializarilor, etc.
Administrator scolar -> se ocupa de adaugarea profesorilor, elevilor, etc. a liceului la care este asignat.
Profesor -> se ocupa de adaugarea notelor, absentelor, etc. a elevilor la clasele la care preda.
Elev -> poate doar sa isi vada notele.

Diagrama UML:
![image](https://github.com/user-attachments/assets/c8543197-5528-4f79-8d40-02f14a405d5c)
