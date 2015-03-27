#include "stdafx.h"

class scheduleStrength
	{
	public:
		vector<pair<double, string>> teamStrength;
		vector<string> finalRes;

		// comparator for sorting strengths in descending order and team names in ascending order
		static bool myfunction( const pair<double, string>& i, const pair<double, string>& j ) 
			{
				if( i.first < j.first ) return false;
				if( j.first < i.first ) return true;
				return j.second > i.second;
			}
		vector<string> calculate(vector<string> *teams, vector<string> *results)
			{
				double totalWins, totalLoss;
				finalRes.clear();
				
				for(int i=0 ; i< teams->size();i++)
					{
						totalWins = 0.0;
						totalLoss = 0.0;
						for(int j=0 ; j<results->size() ; j++)
							{
								if(j != i) //checking if same team
									{
										string res = results->at(j);
										if(res[i] != '-') // if the team has never played against this team, then dont consider
											{
												for(int k=0 ; k<res.length(); k++)
												{
													if(k != i) // dont consider scores for the same team
														{
															char temp = res[k];

															switch(temp)
																{
																	case 'W': totalWins++; break;
																	case 'L': totalLoss++; break;
																	default:;
																}
														}

												}
											}
										

									}
							}
						
						double strength =(double) (totalWins/(totalWins+totalLoss));
						teamStrength.push_back( pair<double, string>( strength, teams->at(i) ) );
						
					}
				sort(teamStrength.begin(), teamStrength.end(), myfunction);
				for(int y=0;y<teamStrength.size();y++)
					{
						finalRes.push_back(teamStrength.at(y).second);
					}
				teamStrength.clear();
				return finalRes;
			}
	};