//
//  MovieCell.swift
//  iosApp
//
//  Created by lucas.henrique.costa on 16/03/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import Kingfisher

struct MovieCell: View {
    
    private let viewModel: MovieViewModelProtocol
    
    init(viewModel: MovieViewModelProtocol) {
        self.viewModel = viewModel
    }
    
    var body: some View {
        GeometryReader { reader in
            VStack(spacing: 0) {
                KFImage(viewModel.imageURL)
                    .fade(duration: 0.25)
                    .resizable()
                
                HStack {
                    Text(viewModel.title)
                        .foregroundColor(.white)
                    
                    Spacer()
                    
                    Button(action: {
                        //Favorite movie
                    }, label: {
                        Image(systemName: "heart.fill")
                            .resizable()
                            .foregroundColor(.white)
                            .frame(width: 20, height: 20, alignment: .trailing)
                    })
                }
                .padding(.all, 8)
                .frame(height: reader.size.height * 0.2)
                .frame(maxWidth: .infinity)
                .background(Color.blue)
            }
        }
    }
}

struct MovieCell_Previews: PreviewProvider {
    
    final class MovieViewModelPreview: MovieViewModelProtocol {
        var id: Int32 { 1 }
        var title: String { "Movie" }
        var imageURL: URL? { nil }
        
    }
    
    static var previews: some View {
        MovieCell(viewModel: MovieViewModelPreview())
            .previewLayout(.fixed(width: 120, height: 220))
    }
}
