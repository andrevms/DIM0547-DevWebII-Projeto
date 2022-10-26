#!/bin/bash
baseUrl="--url http://localhost:8080/api/categoria"
method="--request POST" 
header='content-type:application/json'

data()
{
cat <<EOF
{
"categoria": "$1"
}
EOF
}

array=("avançado" "intermediario" "basico" "iniciante")

for str in ${array[@]}; do
    echo `curl -L -s -w "%{http_code}" $method $baseUrl --header "$header" -d "$(data $str)"`
done