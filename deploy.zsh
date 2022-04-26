#!/usr/bin/env bash

#Copy execute_commands_on_ec2.sh file which has commands to be executed on server... Here we are copying this file
# every time to automate this process through 'deploy.sh' so that whenever that file changes, it's taken care of
scp -i "~/Downloads/admin.pem" execute_commands_on_ec2.sh ec2-user@ec2-54-166-203-152.compute-1.amazonaws.com:/home/ec2-user

scp -i "~/Downloads/admin.pem" $(pwd)/target/practium-final-0.0.1-SNAPSHOT.jar ec2-user@ec2-54-166-203-152.compute-1.amazonaws.com:/home/ec2-user

ssh -i "~/Downloads/admin.pem" ec2-user@ec2-54-166-203-152.compute-1.amazonaws.com ./execute_commands_on_ec2.sh
