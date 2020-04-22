
# Kars
Project for our  faculty at the "Software Developing Methods" course.

Our Development tool is [Android Studio](https://developer.android.com/studio/?gclid=CjwKCAjw1v_0BRAkEiwALFkj5shFkK4jcEmjuACs56PLhp3SpM5ReHsHvuIH4bbc983MHZ3ximDsCxoCHZIQAvD_BwE&gclsrc=aw.ds)

## Trello
The link to our trello management of the software features is [here](https://trello.com/b/rZlAhM7P/mds "https://trello.com/b/rZlAhM7P/mds")

## Get the project

Installing git-bash: [here](https://www.stanleyulili.com/git/how-to-install-git-bash-on-windows/)(On Windows)

*Advice: Don't use CTRL + V on git bash terminal*

Once installed you have to run the command:

```bash
git clone https://github.com/badeaadi/Kars
```

## UML diagrams
*The diagram describes how the components interact with each other*

```mermaid
sequenceDiagram
LogInActivity->> MainActivity: Log In
LogInActivity->>RegisterActivity: Register
RegisterActivity->> MainActivity: Succesfully registered
