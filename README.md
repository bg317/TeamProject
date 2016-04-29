#Table of Contents
[Authors](#authors)

[Rules](#rules)

[Documentation Entry Point](#docs)


# Build and Play rules

####Building

To build this project. install maven following the directions for maven or the maven IDE plugin.

To build this project from the command line, in its directory after downloading run
```$ mvn exec:java -Dexec.mainClass="dragonspiretournament.Main"```

To build this project from your IDE, run with your maven plugin with
```exec:java -Dexec.mainClass="dragonspiretournament.Main```

To test this project, run mvn test in the directory containing its pom.xml

Alternatively you can import the project and run the dragonspiretournament.Main in whichever way you'd like. There is also a JAR file to run packaged with this. Type java -jar Dragonspiretournament-0.0.1-SNAPSHOT-jar-with-dependencies

You can also build the JAR file to the target directory, in which case run the jar file with the suffix -with-dependencies.

####Playing
To play, you need two players. An initial screen will pop up to select a various set of Dragons. The first dragon selection screen will be player one. Player one can select from the library and turning wheel a dragon to add to his collection. Once player one has confirmed his or her selection, another selection window will pop up. This selection window is for player two to select and confirm his or her selection. Each dragon is represented as a shield and next release we will have an information window for each one. 

After confirming both players' selections, move onto the match screen. The players can select a dragons to add to its dice collection, and a roll will select a random dragon to attack. 

The dice selection currently selects for both players, so each player cannot have a unique dice until next release. 

When rolling, an attack will occur which will be reflected in the status text for each player. The damage is the damage received. If you are out of HP you will either win or a draw will occur. Exit the game after match is over by selecting the X in the top right.

# <a name="authors"></a>Authors

Brandon G.  (id: bg317)

Lloyd A.    (id: lkcallen)

Cheri T.    (id: cmthom10)

Larry S.    (id: lstandage135)

Caleb D.    (id: calebdav)

# <a name="rules"></a>Game Rules and Other Info

Dragonspire Tournament
--------------------------

--
Rules:
--

Title Select Screen:<br/>
Choice 1: Start  (go to Game Begin)<br/>
Choice 2: Leaderboard (go to Leaderboard)<br/>

Game Begin:<br/>
1) Both players choose up to 12 dragons to bring into battle<br/>
2) Both players’ strongholds start with a base of 25 hp<br/>
3) Go to Turn Begin<br/>

Turn Begin:<br/>
1) Player 1 & 2 choose up to 5 dragons of 12 to fill 5 slots on a 6-sided die (player 1 goes first on odds, player 2 on evens)<br/>
2) Player 1 & 2 rolls die for damage<br/>
3) Damage is applied to each side<br/>
4) If both strongholds’ hp is above 0, go back to step 1<br/>
5) If a stronghold’s hp is at 0, go to Game End<br/>

Game End:<br/>
1) Winner is shown on screen<br/>
2) Leaderboards are updated<br/>
3) Click "OK" or close pop-up (go to Title Select Screen)<br/>

Leaderboard:<br/>
choice 1: Back (go to Title Select Screen)<br/>

--
Dragon flavor text:
--

<strong>Igneagnus</strong><br/>

Element: Lava<br/>

A dragon commonly employed by wizards. They are born of an igneous rock submerged in lava on a night of a harvest moon. They are popular among apprentices because they are relatively easy to create, mild mannered, and eager to please their masters. Badly trained specimens are known to drool magma when praised. 

Attack damage Base: 5

Type Strong Against: Flora

<strong>Tenebret</strong><br/>

Element: Ice<br/>

This dragon emerges fully formed from ancient, undisturbed ice flows on moonless nights. It imprints on the first wizard it sees after emerging. Tenebrets have the curious trait of always being surrounded by a swirling front of frigid air; stingy wizards sometimes employ them as full-time refrigerators.

Attack damage base: 5

Type Strong Against: Lava

<strong>Arinial</strong><br/>

Element: Metal<br/>

Arinals are golem dragons born from chunks of ore. Arinials will eat any metal they are given, but rusted metals make them sick. Their carapaces will take on the colors and strengths of the metals they are fed. For the best-fortified coats, arinials should eat combinations of steel, wolfram, chromium, and titanium.

Attack damage base: 5

Type Strong Against: Ice

<strong>Skenna</strong></br>

Element: Goo</br>

Their beards are made of the adhesive paste that they produce in a gland in their mouths. The shapes and forms of their beards are quite complex and are believed to be a kind of self-expression. Since their adhesive paste hardens into a cement-like substance, skennas are popular among wizards who like to handle their own home repairs.

Attack damage base: 5

Type Strong Against: Storm

<strong>Fladoen</strong><br/>

Element: Solar

Fladoens like to hum and sing, and will repeat back tunes that are played for them. Because they sit very still and are inclined to inaction, they may be mistaken for gargoyles.

Attack damage base: 5

Type Strong Against: Goo

<strong>Galthi</strong><br/>

Element: Storm<br/>

Often mistaken for a familiar by regular folk, these dragons are small enough to ride on their masters’ shoulders, but no less potent than their larger counterparts. They are the protector of choice for the traveling wizard.  Galthi are born of a gecko that has ingested a rare electrical reagent called a Cloudsphere. It is commonly believed that the first Galthi was created by mistake. No one would purposely waste a Cloudsphere like that, would they?

Attack damage base: 5

Type Strong Against: Metal

<strong>Trudrake</strong><br/>

Element: Flora<br/>

These dragons are a kind of sentient plant related to the fabled mandrake. Grown like a plant, they are immobile until fully mature. They do not have a mouth, instead absorbing energy from the sun through their skin and water through their root-like legs and tail.

Attack damage base: 5

Type Strong Against: Solar

# <a name="docs" href="docs"></a>Documentation Entry Point

https://github.com/bg317/TeamProject/tree/master/docs

