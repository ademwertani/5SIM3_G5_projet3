pipeline {
    agent any

    environment {
        SONARSERVER = 'sonarserver'  // Replace with your SonarQube server configuration name
        SONARSCANNER = 'sonarscanner'  // Replace with your SonarScanner tool name
    }

    stages {
        stage("GIT") {
            steps {
                withCredentials([string(credentialsId: 'github-pat', variable: 'GITHUB_PAT')]) {
                    sh "git clone https://${GITHUB_PAT}@github.com/ademwertani/5SIM3_G5_projet3.git"
                }
            }
        }

        stage("MVN CLEAN") {
            steps {
                sh 'mvn clean'  // Modify Maven goal if needed
            }
        }

        stage("MVN COMPILE") {
            steps {
                sh 'mvn compile'  // Modify Maven goal if needed
            }
        }

        stage('Sonar Analysis') {
            steps {
                script {
                    def scannerHome = tool("${SONARSCANNER}")
                    def scannerOpts = '''
                        -Dsonar.projectKey=vprofile \
                        -Dsonar.projectName=vprofile \
                        -Dsonar.projectVersion=1.0 \
                        -Dsonar.sources=src/ \
                        -Dsonar.java.binaries=target/test.classes/com/visualpathit/account/controllerTest/ \
                        -Dsonar.junit.reportsPath=target/surefire.reports/ \
                        -Dsonar.jacoco.reportsPath=target/jacoco.exec \
                        -Dsonar.java.checkstyle.reportPaths=target/checkstyle-result.xml
                    '''
                    sh "${scannerHome}/bin/sonar-scanner ${scannerOpts}"
                }
            }
        }

        stage("build") {
            steps {
                echo 'building the application...'  // Replace with actual build steps
            }
        }

        stage("test") {
            steps {
                echo 'testing the application...'  // Replace with actual test steps
            }
        }

        stage("deploy") {
            steps {
                echo 'deploying the application'  // Replace with actual deployment steps
            }
        }
    }
}


