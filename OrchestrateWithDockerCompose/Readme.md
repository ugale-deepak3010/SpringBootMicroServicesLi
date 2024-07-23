

GOAL: Build & Deploy on one command line.

1.	Compile All three microServices.
2.	Create Docker images for all three MicroServices with JIB.
3.	Download and Launch MongoDB images, and configure it.
4.	Download and Launch MySQL images, and configure it.

5.	Launch and Configure exlporeTour images:latestTag, hiding port 8082
6.	Launch and Configure Images images:latestTag, hiding port 8081
6.	Launch and Configure Gateway image:latestTag, expose port 8080


>mvn clean compile jib:dockerbuild && docker-compose up











