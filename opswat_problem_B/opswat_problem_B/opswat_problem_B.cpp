// opswat_problem_B.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "scheduleStrength.cpp"

int main()
	{
		vector<string> teams ;
		vector<string> results;
		vector<string> finalRes;
		teams.push_back("BEARS");
		teams.push_back("GIANTS");
		teams.push_back("COWBOYS");
		teams.push_back("BRONCOS");
		teams.push_back("DOLPHINS");
		teams.push_back("LIONS");

		results.push_back("-WLWW-");
		results.push_back("L-WL-W");
		results.push_back("WL---W");
		results.push_back("LW--L-");
		results.push_back("L--W--");
		results.push_back("-LL---");

		scheduleStrength a;
		finalRes = a.calculate(&teams,&results);

		for(int j=0 ; j<finalRes.size(); j++)
			cout<<finalRes.at(j)<<"\n";

		cout<<"\n\n\n";
		teams.clear();
		results.clear();
		finalRes.clear();

		teams.push_back("BEARS");
		teams.push_back("COWBOYS");
		teams.push_back("GIANTS");
		teams.push_back("PACKERS");
		results.push_back("-LLW");
		results.push_back("W-WW");
		results.push_back("WL--");
		results.push_back("LL--");

		finalRes = a.calculate(&teams,&results);

		for(int j=0 ; j<finalRes.size(); j++)
			cout<<finalRes.at(j)<<"\n";

		getch();
	}

