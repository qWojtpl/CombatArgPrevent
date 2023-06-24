<p align="center">
  <img src="https://media.discordapp.net/attachments/816647374239694849/1103672044048105492/da70653474c3d58b6682e0b2203336cff5539227da39a3ee5e6b4b0d3255bfef95601890afd80709da39a3ee5e6b4b0d3255bfef95601890afd807090fe44f22b48c80262fc78bf1414d24e3.png">
</p>

<br>

# CombatArgPrevent

<p>REQUIRES DELUXECOMBAT</p>
<p>Prevent from sending commands when argument-player is in combat on your Minecraft server.</p>
<p>Tested minecraft versions: </p> 

`1.19.3`

# Installation

<p>Get DeluxeCombat from https://www.spigotmc.org/resources/%E2%9C%A6-deluxecombat-%E2%9C%A6-ultimate-powerful-combat-resource-for-every-server.63970/</p>
<p>Put CombatArgPrevent.jar to your plugins folder and restart the server.</p>

# Configuration

<details><summary>config.yml</summary>

<br>

`message` - Message when arg-player is in combat<br>
`commands` - List of commands which will be prevented when arg-player is in combat. Use %player% to select which argument is arg-player and must be checked<br>

Example:<br>
`/tpacccept %player%` - Prevent from accepting tpa when %player% is in combat<br>
`/msg %player% abc` - Prevent from messaging to %player% when %player% is in combat

</details>