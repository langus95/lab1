# lab1
języki programowania lab

Zadanie 1:

Zaimplementuj  prosty  parser  tekstu.  Parser  powinien  czytać  stronę  internetową  z  pliku  lub 

adresu  URL.  Użytkownik  powinien  mieć  możliwośc  wyboru,  lub  program  sam  powinien  to 

rozpoznać np po poczatku tekstu (http:// lub www oznacza stronę). 

Parser ma za zadanie znaleźć wszystkie linki na stronie (link jest w tagu <a href=”link” />), 

policzyć je i wyświetlić użytkownikowi. 

Użytkownik  powinien  mieć  możliwośc  wyboru  czy  chce  widzieć  wszystkie  linki  czy  tylko  te  z 

aktualnej  domeny.  Po  znalezieniu  wszystkich  linków,  pokaż  ich  ilośc  i  zapytaj  czy  chce 

zobaczyć  je  wszystkie,  Jeżeli  tak  po  prostu  wyświetl.  Zapytaj  czy  użytkownik  chce  zobaczyć 

całe źródło strony i z których linków (powinien podać numer kolejny linku).

Zmienne  pobierane  przez  usera  moga  być  na  sztywno  ustawione  w  pliku  konfiguracyjnym 

(tekstowym a nie Javy)

Proponuję  stworzyć  dwie  klasy  WebPageReader i  FileReader,  oraz  AbstractReader z 

abstrakcyjną metodą read, która zostanie nadpisana w każdej implementacji readera.
