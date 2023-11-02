pipeline {
    agent any

    tools {
    // Define your SonarQube server tool
    sonarqube 'SONARSERVER'
    }

    environment {
        SONARSERVER = 'sonarserver'
        SONARSCANNER = 'sonarscanner'
    }

    stages {
        stage("GIT") {
    steps {
        withCredentials([string(credentialsId: 'github-pat', variable: 'GITHUB_PAT')]) {
            // Clone the Git repository using the PAT
            sh "git clone https://${GITHUB_PAT}@github.com/ademwertani/5SIM3_G5_projet3.git"
        }
    }
}


        stage("MVN CLEAN") {
            steps {
                // Run 'mvn clean' in the project directory
                sh 'mvn clean'
            }
        }

        stage("MVN COMPILE") {
            steps {
                // Run 'mvn compile' in the project directory
                sh 'mvn compile'
            }
        }

        stage('Sonar Analysis') {
            environment {
                scannerHome = tool("${SONARSCANNER}")
            }
            steps {
                withSonarQubeEnv("$(SONARSERVER)") {
                    sh '''$(scannerHome)/bin/sonar-scanner -Dsonar-projectkey=vprofile \
                    -Dsonar.projectName=vprofile \
                    -Dsonnar.projectVersion=1.0 \
                    -Dsonar.sources=src/ \
                    -Dsonar.java.binaries=target/test.classes/com/visualpathit/account/controllerTest/ \
                    -Dsonar.junit.reportsPath=target/surefire.reports/ \
                    -Dsonar.jacoco.reportsPath=target/jacoco.exec \
                    -Dsonar.java.checkstyle.reportPaths=target/checkstyle-result.xml'''
                }
            }
        }

        stage("build") {
            steps {
                echo 'building the application...'
            }
        }

        stage("test") {
            steps {
                echo 'testing the application...'
            }
        }

        stage("deploy") {
            steps {
                echo 'deploying the application'
            }
        }
    }
}

