# Adwentuj z Kotlinem 2024 - JVM Template 

## Struktura
Każde zadanie przewidziane jest jako osobny moduł Gradle, z którego budowany będzie docelowo uruchamiany artefakt.

W każdym module, w katalogu `src/main/resources` powinien znaleźć się input na dany dzień zadania.

W każdym module, w katalogu `src/main/kotlin` znajduje się plik `Day[1-7].kt`, w którym należy zaimplementować rozwiązania - odpowiednio w funkcjach `part1` oraz `part2`. Rezultat obliczeń z każdej części powinien być zwracany na `stdout`.

## Kompilacja
Ostatecznym produktem kompilacji powinien być artefakt zbudowany przy pomocy polecenia `./gradlew assemble`, który następnie można poprawnie uruchomić poprzez komendę `java $JAVA_OPTS -jar <nazwa_artefaktu>.jar` bez przekazywania dodatkowych argumentów.

## JAVA_OPTS
W każdym module w katalogu `resources` znajduje się plik `JAVA_OPTS`, który można wykorzystać do ustawienia własnych flag JVM celem optymalizacji procesu w najlepszym możliwym zakresie.
